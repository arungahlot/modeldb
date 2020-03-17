// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.modeldb.versioning.autogenerated._public.modeldb.versioning.model;

import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.versioning.*;
import ai.verta.modeldb.versioning.blob.diff.*;
import ai.verta.modeldb.versioning.blob.diff.Function3;
import ai.verta.modeldb.versioning.blob.visitors.Visitor;
import java.util.*;
import java.util.function.Function;

public class Blob implements ProtoType {
  public Optional<DatasetBlob> Dataset;
  public Optional<EnvironmentBlob> Environment;
  public Optional<CodeBlob> Code;
  public Optional<ConfigBlob> Config;

  public Blob() {
    this.Dataset = Optional.empty();
    this.Environment = Optional.empty();
    this.Code = Optional.empty();
    this.Config = Optional.empty();
  }

  public Boolean isEmpty() {
    if (this.Dataset.isPresent()) {
      return false;
    }
    if (this.Environment.isPresent()) {
      return false;
    }
    if (this.Code.isPresent()) {
      return false;
    }
    if (this.Config.isPresent()) {
      return false;
    }
    return true;
  }

  // TODO: not consider order on lists
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (!(o instanceof Blob)) return false;
    Blob other = (Blob) o;

    {
      Function3<DatasetBlob, DatasetBlob, Boolean> f = (x, y) -> x.equals(y);
      if (this.Dataset.isPresent() || other.Dataset.isPresent()) {
        if (!this.Dataset.isPresent()) return false;
        if (other.Dataset.isPresent()) return false;
        if (!f.apply(this.Dataset.get(), other.Dataset.get())) return false;
      }
    }
    {
      Function3<EnvironmentBlob, EnvironmentBlob, Boolean> f = (x, y) -> x.equals(y);
      if (this.Environment.isPresent() || other.Environment.isPresent()) {
        if (!this.Environment.isPresent()) return false;
        if (other.Environment.isPresent()) return false;
        if (!f.apply(this.Environment.get(), other.Environment.get())) return false;
      }
    }
    {
      Function3<CodeBlob, CodeBlob, Boolean> f = (x, y) -> x.equals(y);
      if (this.Code.isPresent() || other.Code.isPresent()) {
        if (!this.Code.isPresent()) return false;
        if (other.Code.isPresent()) return false;
        if (!f.apply(this.Code.get(), other.Code.get())) return false;
      }
    }
    {
      Function3<ConfigBlob, ConfigBlob, Boolean> f = (x, y) -> x.equals(y);
      if (this.Config.isPresent() || other.Config.isPresent()) {
        if (!this.Config.isPresent()) return false;
        if (other.Config.isPresent()) return false;
        if (!f.apply(this.Config.get(), other.Config.get())) return false;
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.Dataset, this.Environment, this.Code, this.Config);
  }

  public Blob setDataset(Optional<DatasetBlob> value) {
    this.Dataset = value;
    return this;
  }

  public Blob setDataset(DatasetBlob value) {
    if (value == null) this.Dataset = Optional.empty();
    else this.Dataset = Optional.of(value);
    return this;
  }

  public Blob setEnvironment(Optional<EnvironmentBlob> value) {
    this.Environment = value;
    return this;
  }

  public Blob setEnvironment(EnvironmentBlob value) {
    if (value == null) this.Environment = Optional.empty();
    else this.Environment = Optional.of(value);
    return this;
  }

  public Blob setCode(Optional<CodeBlob> value) {
    this.Code = value;
    return this;
  }

  public Blob setCode(CodeBlob value) {
    if (value == null) this.Code = Optional.empty();
    else this.Code = Optional.of(value);
    return this;
  }

  public Blob setConfig(Optional<ConfigBlob> value) {
    this.Config = value;
    return this;
  }

  public Blob setConfig(ConfigBlob value) {
    if (value == null) this.Config = Optional.empty();
    else this.Config = Optional.of(value);
    return this;
  }

  public static Blob fromProto(ai.verta.modeldb.versioning.Blob blob) {
    if (blob == null) {
      return null;
    }

    Blob obj = new Blob();
    {
      Function<ai.verta.modeldb.versioning.Blob, DatasetBlob> f =
          x -> DatasetBlob.fromProto(blob.getDataset());
      obj.Dataset = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.Blob, EnvironmentBlob> f =
          x -> EnvironmentBlob.fromProto(blob.getEnvironment());
      obj.Environment = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.Blob, CodeBlob> f =
          x -> CodeBlob.fromProto(blob.getCode());
      obj.Code = Utils.removeEmpty(f.apply(blob));
    }
    {
      Function<ai.verta.modeldb.versioning.Blob, ConfigBlob> f =
          x -> ConfigBlob.fromProto(blob.getConfig());
      obj.Config = Utils.removeEmpty(f.apply(blob));
    }
    return obj;
  }

  public ai.verta.modeldb.versioning.Blob.Builder toProto() {
    ai.verta.modeldb.versioning.Blob.Builder builder =
        ai.verta.modeldb.versioning.Blob.newBuilder();
    this.Dataset.ifPresent(x -> builder.setDataset(x.toProto()));
    this.Environment.ifPresent(x -> builder.setEnvironment(x.toProto()));
    this.Code.ifPresent(x -> builder.setCode(x.toProto()));
    this.Config.ifPresent(x -> builder.setConfig(x.toProto()));
    return builder;
  }

  public void preVisitShallow(Visitor visitor) throws ModelDBException {
    visitor.preVisitBlob(this);
  }

  public void preVisitDeep(Visitor visitor) throws ModelDBException {
    this.preVisitShallow(visitor);
    if (this.Dataset.isPresent()) visitor.preVisitDeepDatasetBlob(this.Dataset.get());
    if (this.Environment.isPresent()) visitor.preVisitDeepEnvironmentBlob(this.Environment.get());
    if (this.Code.isPresent()) visitor.preVisitDeepCodeBlob(this.Code.get());
    if (this.Config.isPresent()) visitor.preVisitDeepConfigBlob(this.Config.get());
  }

  public Blob postVisitShallow(Visitor visitor) throws ModelDBException {
    return visitor.postVisitBlob(this);
  }

  public Blob postVisitDeep(Visitor visitor) throws ModelDBException {
    if (this.Dataset.isPresent())
      this.setDataset(visitor.postVisitDeepDatasetBlob(this.Dataset.get()));
    if (this.Environment.isPresent())
      this.setEnvironment(visitor.postVisitDeepEnvironmentBlob(this.Environment.get()));
    if (this.Code.isPresent()) this.setCode(visitor.postVisitDeepCodeBlob(this.Code.get()));
    if (this.Config.isPresent()) this.setConfig(visitor.postVisitDeepConfigBlob(this.Config.get()));
    return this.postVisitShallow(visitor);
  }
}