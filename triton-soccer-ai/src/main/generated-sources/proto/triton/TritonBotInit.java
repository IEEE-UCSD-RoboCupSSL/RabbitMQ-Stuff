// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: triton_bot_init.proto

package proto.triton;

public final class TritonBotInit {
  private TritonBotInit() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface InitOrBuilder extends
      // @@protoc_insertion_point(interface_extends:proto.triton.Init)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 id = 1;</code>
     */
    int getId();
  }
  /**
   * Protobuf type {@code proto.triton.Init}
   */
  public  static final class Init extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:proto.triton.Init)
      InitOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Init.newBuilder() to construct.
    private Init(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Init() {
      id_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Init(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {

              id_ = input.readInt32();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proto.triton.TritonBotInit.internal_static_proto_triton_Init_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proto.triton.TritonBotInit.internal_static_proto_triton_Init_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proto.triton.TritonBotInit.Init.class, proto.triton.TritonBotInit.Init.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
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
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof proto.triton.TritonBotInit.Init)) {
        return super.equals(obj);
      }
      proto.triton.TritonBotInit.Init other = (proto.triton.TritonBotInit.Init) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static proto.triton.TritonBotInit.Init parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static proto.triton.TritonBotInit.Init parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static proto.triton.TritonBotInit.Init parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static proto.triton.TritonBotInit.Init parseFrom(
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
    public static Builder newBuilder(proto.triton.TritonBotInit.Init prototype) {
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
     * Protobuf type {@code proto.triton.Init}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:proto.triton.Init)
        proto.triton.TritonBotInit.InitOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return proto.triton.TritonBotInit.internal_static_proto_triton_Init_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return proto.triton.TritonBotInit.internal_static_proto_triton_Init_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                proto.triton.TritonBotInit.Init.class, proto.triton.TritonBotInit.Init.Builder.class);
      }

      // Construct using proto.triton.TritonBotInit.Init.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = 0;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return proto.triton.TritonBotInit.internal_static_proto_triton_Init_descriptor;
      }

      @java.lang.Override
      public proto.triton.TritonBotInit.Init getDefaultInstanceForType() {
        return proto.triton.TritonBotInit.Init.getDefaultInstance();
      }

      @java.lang.Override
      public proto.triton.TritonBotInit.Init build() {
        proto.triton.TritonBotInit.Init result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public proto.triton.TritonBotInit.Init buildPartial() {
        proto.triton.TritonBotInit.Init result = new proto.triton.TritonBotInit.Init(this);
        result.id_ = id_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof proto.triton.TritonBotInit.Init) {
          return mergeFrom((proto.triton.TritonBotInit.Init)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(proto.triton.TritonBotInit.Init other) {
        if (other == proto.triton.TritonBotInit.Init.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        this.mergeUnknownFields(other.unknownFields);
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
        proto.triton.TritonBotInit.Init parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (proto.triton.TritonBotInit.Init) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int id_ ;
      /**
       * <code>int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:proto.triton.Init)
    }

    // @@protoc_insertion_point(class_scope:proto.triton.Init)
    private static final proto.triton.TritonBotInit.Init DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new proto.triton.TritonBotInit.Init();
    }

    public static proto.triton.TritonBotInit.Init getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Init>
        PARSER = new com.google.protobuf.AbstractParser<Init>() {
      @java.lang.Override
      public Init parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Init(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Init> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Init> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public proto.triton.TritonBotInit.Init getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proto_triton_Init_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proto_triton_Init_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025triton_bot_init.proto\022\014proto.triton\"\022\n" +
      "\004Init\022\n\n\002id\030\001 \001(\005b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proto_triton_Init_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proto_triton_Init_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proto_triton_Init_descriptor,
        new java.lang.String[] { "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}