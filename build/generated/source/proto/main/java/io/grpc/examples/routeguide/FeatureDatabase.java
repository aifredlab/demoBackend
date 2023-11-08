// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: route_guide.proto

package io.grpc.examples.routeguide;

/**
 * <pre>
 * Not used in the RPC.  Instead, this is here for the form serialized to disk.
 * </pre>
 *
 * Protobuf type {@code routeguide.FeatureDatabase}
 */
public final class FeatureDatabase extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:routeguide.FeatureDatabase)
    FeatureDatabaseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FeatureDatabase.newBuilder() to construct.
  private FeatureDatabase(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FeatureDatabase() {
    feature_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FeatureDatabase();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.grpc.examples.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.grpc.examples.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.grpc.examples.routeguide.FeatureDatabase.class, io.grpc.examples.routeguide.FeatureDatabase.Builder.class);
  }

  public static final int FEATURE_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<io.grpc.examples.routeguide.Feature> feature_;
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.grpc.examples.routeguide.Feature> getFeatureList() {
    return feature_;
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.grpc.examples.routeguide.FeatureOrBuilder> 
      getFeatureOrBuilderList() {
    return feature_;
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  @java.lang.Override
  public int getFeatureCount() {
    return feature_.size();
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  @java.lang.Override
  public io.grpc.examples.routeguide.Feature getFeature(int index) {
    return feature_.get(index);
  }
  /**
   * <code>repeated .routeguide.Feature feature = 1;</code>
   */
  @java.lang.Override
  public io.grpc.examples.routeguide.FeatureOrBuilder getFeatureOrBuilder(
      int index) {
    return feature_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < feature_.size(); i++) {
      output.writeMessage(1, feature_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < feature_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, feature_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.grpc.examples.routeguide.FeatureDatabase)) {
      return super.equals(obj);
    }
    io.grpc.examples.routeguide.FeatureDatabase other = (io.grpc.examples.routeguide.FeatureDatabase) obj;

    if (!getFeatureList()
        .equals(other.getFeatureList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getFeatureCount() > 0) {
      hash = (37 * hash) + FEATURE_FIELD_NUMBER;
      hash = (53 * hash) + getFeatureList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.grpc.examples.routeguide.FeatureDatabase parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.grpc.examples.routeguide.FeatureDatabase parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.grpc.examples.routeguide.FeatureDatabase parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.routeguide.FeatureDatabase prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Not used in the RPC.  Instead, this is here for the form serialized to disk.
   * </pre>
   *
   * Protobuf type {@code routeguide.FeatureDatabase}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:routeguide.FeatureDatabase)
      io.grpc.examples.routeguide.FeatureDatabaseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.grpc.examples.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.grpc.examples.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.grpc.examples.routeguide.FeatureDatabase.class, io.grpc.examples.routeguide.FeatureDatabase.Builder.class);
    }

    // Construct using io.grpc.examples.routeguide.FeatureDatabase.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (featureBuilder_ == null) {
        feature_ = java.util.Collections.emptyList();
      } else {
        feature_ = null;
        featureBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.grpc.examples.routeguide.RouteGuideProto.internal_static_routeguide_FeatureDatabase_descriptor;
    }

    @java.lang.Override
    public io.grpc.examples.routeguide.FeatureDatabase getDefaultInstanceForType() {
      return io.grpc.examples.routeguide.FeatureDatabase.getDefaultInstance();
    }

    @java.lang.Override
    public io.grpc.examples.routeguide.FeatureDatabase build() {
      io.grpc.examples.routeguide.FeatureDatabase result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.grpc.examples.routeguide.FeatureDatabase buildPartial() {
      io.grpc.examples.routeguide.FeatureDatabase result = new io.grpc.examples.routeguide.FeatureDatabase(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(io.grpc.examples.routeguide.FeatureDatabase result) {
      if (featureBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          feature_ = java.util.Collections.unmodifiableList(feature_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.feature_ = feature_;
      } else {
        result.feature_ = featureBuilder_.build();
      }
    }

    private void buildPartial0(io.grpc.examples.routeguide.FeatureDatabase result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.grpc.examples.routeguide.FeatureDatabase) {
        return mergeFrom((io.grpc.examples.routeguide.FeatureDatabase)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.grpc.examples.routeguide.FeatureDatabase other) {
      if (other == io.grpc.examples.routeguide.FeatureDatabase.getDefaultInstance()) return this;
      if (featureBuilder_ == null) {
        if (!other.feature_.isEmpty()) {
          if (feature_.isEmpty()) {
            feature_ = other.feature_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureFeatureIsMutable();
            feature_.addAll(other.feature_);
          }
          onChanged();
        }
      } else {
        if (!other.feature_.isEmpty()) {
          if (featureBuilder_.isEmpty()) {
            featureBuilder_.dispose();
            featureBuilder_ = null;
            feature_ = other.feature_;
            bitField0_ = (bitField0_ & ~0x00000001);
            featureBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFeatureFieldBuilder() : null;
          } else {
            featureBuilder_.addAllMessages(other.feature_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              io.grpc.examples.routeguide.Feature m =
                  input.readMessage(
                      io.grpc.examples.routeguide.Feature.parser(),
                      extensionRegistry);
              if (featureBuilder_ == null) {
                ensureFeatureIsMutable();
                feature_.add(m);
              } else {
                featureBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<io.grpc.examples.routeguide.Feature> feature_ =
      java.util.Collections.emptyList();
    private void ensureFeatureIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        feature_ = new java.util.ArrayList<io.grpc.examples.routeguide.Feature>(feature_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.grpc.examples.routeguide.Feature, io.grpc.examples.routeguide.Feature.Builder, io.grpc.examples.routeguide.FeatureOrBuilder> featureBuilder_;

    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<io.grpc.examples.routeguide.Feature> getFeatureList() {
      if (featureBuilder_ == null) {
        return java.util.Collections.unmodifiableList(feature_);
      } else {
        return featureBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public int getFeatureCount() {
      if (featureBuilder_ == null) {
        return feature_.size();
      } else {
        return featureBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public io.grpc.examples.routeguide.Feature getFeature(int index) {
      if (featureBuilder_ == null) {
        return feature_.get(index);
      } else {
        return featureBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder setFeature(
        int index, io.grpc.examples.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.set(index, value);
        onChanged();
      } else {
        featureBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder setFeature(
        int index, io.grpc.examples.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.set(index, builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(io.grpc.examples.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.add(value);
        onChanged();
      } else {
        featureBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        int index, io.grpc.examples.routeguide.Feature value) {
      if (featureBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeatureIsMutable();
        feature_.add(index, value);
        onChanged();
      } else {
        featureBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        io.grpc.examples.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.add(builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addFeature(
        int index, io.grpc.examples.routeguide.Feature.Builder builderForValue) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.add(index, builderForValue.build());
        onChanged();
      } else {
        featureBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder addAllFeature(
        java.lang.Iterable<? extends io.grpc.examples.routeguide.Feature> values) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, feature_);
        onChanged();
      } else {
        featureBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder clearFeature() {
      if (featureBuilder_ == null) {
        feature_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        featureBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public Builder removeFeature(int index) {
      if (featureBuilder_ == null) {
        ensureFeatureIsMutable();
        feature_.remove(index);
        onChanged();
      } else {
        featureBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public io.grpc.examples.routeguide.Feature.Builder getFeatureBuilder(
        int index) {
      return getFeatureFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public io.grpc.examples.routeguide.FeatureOrBuilder getFeatureOrBuilder(
        int index) {
      if (featureBuilder_ == null) {
        return feature_.get(index);  } else {
        return featureBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<? extends io.grpc.examples.routeguide.FeatureOrBuilder> 
         getFeatureOrBuilderList() {
      if (featureBuilder_ != null) {
        return featureBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(feature_);
      }
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public io.grpc.examples.routeguide.Feature.Builder addFeatureBuilder() {
      return getFeatureFieldBuilder().addBuilder(
          io.grpc.examples.routeguide.Feature.getDefaultInstance());
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public io.grpc.examples.routeguide.Feature.Builder addFeatureBuilder(
        int index) {
      return getFeatureFieldBuilder().addBuilder(
          index, io.grpc.examples.routeguide.Feature.getDefaultInstance());
    }
    /**
     * <code>repeated .routeguide.Feature feature = 1;</code>
     */
    public java.util.List<io.grpc.examples.routeguide.Feature.Builder> 
         getFeatureBuilderList() {
      return getFeatureFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        io.grpc.examples.routeguide.Feature, io.grpc.examples.routeguide.Feature.Builder, io.grpc.examples.routeguide.FeatureOrBuilder> 
        getFeatureFieldBuilder() {
      if (featureBuilder_ == null) {
        featureBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            io.grpc.examples.routeguide.Feature, io.grpc.examples.routeguide.Feature.Builder, io.grpc.examples.routeguide.FeatureOrBuilder>(
                feature_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        feature_ = null;
      }
      return featureBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:routeguide.FeatureDatabase)
  }

  // @@protoc_insertion_point(class_scope:routeguide.FeatureDatabase)
  private static final io.grpc.examples.routeguide.FeatureDatabase DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.grpc.examples.routeguide.FeatureDatabase();
  }

  public static io.grpc.examples.routeguide.FeatureDatabase getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FeatureDatabase>
      PARSER = new com.google.protobuf.AbstractParser<FeatureDatabase>() {
    @java.lang.Override
    public FeatureDatabase parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<FeatureDatabase> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FeatureDatabase> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.grpc.examples.routeguide.FeatureDatabase getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

