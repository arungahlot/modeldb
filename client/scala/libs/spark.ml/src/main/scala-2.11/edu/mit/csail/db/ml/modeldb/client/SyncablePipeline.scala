package org.apache.spark.ml

import edu.mit.csail.db.ml.modeldb.client.{HasFitSync, ModelDbSyncer}
import edu.mit.csail.db.ml.modeldb.client.event.{FitPipelineStageEvent, PipelineEvent, PipelineStageEvent, TransformerPipelineStageEvent}
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.sql.DataFrame

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * This trait defines an implicit class for Pipelines that stores a Pipeline event on the server when the user
  * calls fitSync.
  */
trait SyncablePipeline {
  /**
    * Implicit class for storing pipelines.
    */
  implicit class PipelineFitSync(pipeline: Pipeline) extends HasFitSync[PipelineModel] {

    /**
      * This is a customized version of the fit method which basically just copies code from fit()
      * from Spark's Pipeline.scala with some minor modifications (see comments in the code).
      */
    def customFit(df: DataFrame)(implicit mdbs: Option[ModelDbSyncer]): PipelineModel = {
      val stageEvents = ArrayBuffer[PipelineStageEvent]()

      pipeline.transformSchema(df.schema)
      val theStages = pipeline.getStages
      var curDataset = df
      val transformers = ListBuffer.empty[Transformer]
      theStages.view.foreach { stage =>
        val oldDf = curDataset
        val transformer = stage match {
          case estimator: Estimator[_] =>
            val model = estimator.fit(oldDf)
            val newDf = model.transform(oldDf)
            if (mdbs.isDefined && mdbs.get.getFeaturesForDf(df).isDefined)
              mdbs.get.setFeaturesForDf(oldDf, mdbs.get.getFeaturesForDf(df).get)
            stageEvents.append(FitPipelineStageEvent(oldDf, newDf, estimator, model))
            curDataset = newDf
            model
          case transformer: Transformer =>
            val newDf = transformer.transform(oldDf)
            stageEvents.append(TransformerPipelineStageEvent(oldDf, newDf, transformer))
            curDataset = newDf
            transformer
          case _ =>
            throw new IllegalArgumentException(
              s"Do not support stage $stage of type ${stage.getClass}")
        }
        transformers += transformer
      }

      val model = new PipelineModel(pipeline.uid, transformers.toArray).setParent(pipeline)
      mdbs.get.buffer(PipelineEvent(pipeline, model, df, stageEvents))
      model
    }

    override def fitSync(df: DataFrame, pms: Array[ParamMap], featureVectorNames: Seq[String])
                        (implicit mdbs: Option[ModelDbSyncer]): Seq[PipelineModel] = {
      if (featureVectorNames.nonEmpty)
        mdbs.get.setFeaturesForDf(df, featureVectorNames)
      if (pms.length == 0) {
        Array(customFit(df))
      } else {
        pms.map(pm => new PipelineFitSync(pipeline.copy(pm)).customFit(df))
      }
    }
  }
}

object SyncablePipeline extends SyncablePipeline {

}