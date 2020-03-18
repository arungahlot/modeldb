package ai.verta.modeldb.versioning.blob;

import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.BlobDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.CodeDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.ConfigDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.DatasetDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.DiffStatusEnumDiffStatus;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.DockerEnvironmentDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.EnvironmentDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.EnvironmentVariablesDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.GitCodeDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.NotebookCodeDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.PathDatasetDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.PythonEnvironmentDiff;
import ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model.S3DatasetDiff;
import ai.verta.modeldb.versioning.blob.diff.Utils;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenerateBlobDiff {
  public static BlobDiff fromProto(ai.verta.modeldb.versioning.BlobDiff blob) {
    if (blob == null) {
      return null;
    }

    BlobDiff obj = new BlobDiff();
    {
      Function<ai.verta.modeldb.versioning.BlobDiff, List<String>> f = x -> blob.getLocationList();
      obj.Location = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.BlobDiff, DiffStatusEnumDiffStatus> f =
          x -> DiffStatusEnumDiffStatus.fromProto(blob.getStatus());
      obj.Status = Utils.removeEmpty(f.apply(blob));
    }

    switch (blob.getContentCase()) {
      case DATASET:
        {
          Function<ai.verta.modeldb.versioning.BlobDiff, DatasetDiff> f =
              x -> fromProto(blob.getDataset());
          obj.Dataset = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case ENVIRONMENT:
        {
          Function<ai.verta.modeldb.versioning.BlobDiff, EnvironmentDiff> f =
              x -> fromProto(blob.getEnvironment());
          obj.Environment = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case CODE:
        {
          Function<ai.verta.modeldb.versioning.BlobDiff, CodeDiff> f =
              x -> fromProto(blob.getCode());
          obj.Code = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case CONFIG:
        {
          Function<ai.verta.modeldb.versioning.BlobDiff, ConfigDiff> f =
              x -> ConfigDiff.fromProto(blob.getConfig());
          obj.Config = Utils.removeEmpty(f.apply(blob));
        }
        break;
    }
    return obj;
  }

  public static EnvironmentDiff fromProto(ai.verta.modeldb.versioning.EnvironmentDiff blob) {
    if (blob == null) {
      return null;
    }

    EnvironmentDiff obj = new EnvironmentDiff();
    switch (blob.getContentCase()) {
      case PYTHON:
        {
          Function<ai.verta.modeldb.versioning.EnvironmentDiff, PythonEnvironmentDiff> f =
              x -> PythonEnvironmentDiff.fromProto(blob.getPython());
          obj.Python = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case DOCKER:
        {
          Function<ai.verta.modeldb.versioning.EnvironmentDiff, DockerEnvironmentDiff> f =
              x -> DockerEnvironmentDiff.fromProto(blob.getDocker());
          obj.Docker = Utils.removeEmpty(f.apply(blob));
        }
        break;
    }
    {
      Function<ai.verta.modeldb.versioning.EnvironmentDiff, List<EnvironmentVariablesDiff>> f =
          x ->
              blob.getEnvironmentVariablesList().stream()
                  .map(EnvironmentVariablesDiff::fromProto)
                  .collect(Collectors.toList());
      obj.EnvironmentVariables = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.EnvironmentDiff, DiffStatusEnumDiffStatus> f =
          x -> DiffStatusEnumDiffStatus.fromProto(blob.getCommandLineStatus());
      obj.CommandLineStatus = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.EnvironmentDiff, List<String>> f =
          x -> blob.getCommandLineAList();
      obj.CommandLineA = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.EnvironmentDiff, List<String>> f =
          x -> blob.getCommandLineBList();
      obj.CommandLineB = Utils.removeEmpty(f.apply(blob));
    }
    return obj;
  }

  public static DatasetDiff fromProto(ai.verta.modeldb.versioning.DatasetDiff blob) {
    if (blob == null) {
      return null;
    }

    DatasetDiff obj = new DatasetDiff();
    switch (blob.getContentCase()) {
      case S3:
        {
          Function<ai.verta.modeldb.versioning.DatasetDiff, S3DatasetDiff> f =
              x -> S3DatasetDiff.fromProto(blob.getS3());
          obj.S3 = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case PATH:
        {
          Function<ai.verta.modeldb.versioning.DatasetDiff, PathDatasetDiff> f =
              x -> PathDatasetDiff.fromProto(blob.getPath());
          obj.Path = Utils.removeEmpty(f.apply(blob));
        }
        break;
    }
    return obj;
  }

  public static CodeDiff fromProto(ai.verta.modeldb.versioning.CodeDiff blob) {
    if (blob == null) {
      return null;
    }

    CodeDiff obj = new CodeDiff();
    switch (blob.getContentCase()) {
      case GIT:
        {
          Function<ai.verta.modeldb.versioning.CodeDiff, GitCodeDiff> f =
              x -> GitCodeDiff.fromProto(blob.getGit());
          obj.Git = Utils.removeEmpty(f.apply(blob));
        }
        break;
      case NOTEBOOK:
        {
          Function<ai.verta.modeldb.versioning.CodeDiff, NotebookCodeDiff> f =
              x -> NotebookCodeDiff.fromProto(blob.getNotebook());
          obj.Notebook = Utils.removeEmpty(f.apply(blob));
        }
        break;
    }
    return obj;
  }
}