package io.grpc.demo.ask;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: dialogue.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommunicatorGrpc {

  private CommunicatorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "demo.Communicator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<io.grpc.demo.ask.Message,
      io.grpc.demo.ask.Content> getSearchContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchContent",
      requestType = io.grpc.demo.ask.Message.class,
      responseType = io.grpc.demo.ask.Content.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.demo.ask.Message,
      io.grpc.demo.ask.Content> getSearchContentMethod() {
    io.grpc.MethodDescriptor<io.grpc.demo.ask.Message, io.grpc.demo.ask.Content> getSearchContentMethod;
    if ((getSearchContentMethod = CommunicatorGrpc.getSearchContentMethod) == null) {
      synchronized (CommunicatorGrpc.class) {
        if ((getSearchContentMethod = CommunicatorGrpc.getSearchContentMethod) == null) {
          CommunicatorGrpc.getSearchContentMethod = getSearchContentMethod =
              io.grpc.MethodDescriptor.<io.grpc.demo.ask.Message, io.grpc.demo.ask.Content>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Message.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Content.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicatorMethodDescriptorSupplier("searchContent"))
              .build();
        }
      }
    }
    return getSearchContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Conversation> getAskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ask",
      requestType = io.grpc.demo.ask.Conversation.class,
      responseType = io.grpc.demo.ask.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Conversation> getAskMethod() {
    io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Conversation> getAskMethod;
    if ((getAskMethod = CommunicatorGrpc.getAskMethod) == null) {
      synchronized (CommunicatorGrpc.class) {
        if ((getAskMethod = CommunicatorGrpc.getAskMethod) == null) {
          CommunicatorGrpc.getAskMethod = getAskMethod =
              io.grpc.MethodDescriptor.<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Conversation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Conversation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Conversation.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicatorMethodDescriptorSupplier("ask"))
              .build();
        }
      }
    }
    return getAskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Message> getAskStreamReplyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "askStreamReply",
      requestType = io.grpc.demo.ask.Conversation.class,
      responseType = io.grpc.demo.ask.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Message> getAskStreamReplyMethod() {
    io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Message> getAskStreamReplyMethod;
    if ((getAskStreamReplyMethod = CommunicatorGrpc.getAskStreamReplyMethod) == null) {
      synchronized (CommunicatorGrpc.class) {
        if ((getAskStreamReplyMethod = CommunicatorGrpc.getAskStreamReplyMethod) == null) {
          CommunicatorGrpc.getAskStreamReplyMethod = getAskStreamReplyMethod =
              io.grpc.MethodDescriptor.<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "askStreamReply"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Conversation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Message.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicatorMethodDescriptorSupplier("askStreamReply"))
              .build();
        }
      }
    }
    return getAskStreamReplyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Conversation> getAskBidiStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "askBidiStream",
      requestType = io.grpc.demo.ask.Conversation.class,
      responseType = io.grpc.demo.ask.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation,
      io.grpc.demo.ask.Conversation> getAskBidiStreamMethod() {
    io.grpc.MethodDescriptor<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Conversation> getAskBidiStreamMethod;
    if ((getAskBidiStreamMethod = CommunicatorGrpc.getAskBidiStreamMethod) == null) {
      synchronized (CommunicatorGrpc.class) {
        if ((getAskBidiStreamMethod = CommunicatorGrpc.getAskBidiStreamMethod) == null) {
          CommunicatorGrpc.getAskBidiStreamMethod = getAskBidiStreamMethod =
              io.grpc.MethodDescriptor.<io.grpc.demo.ask.Conversation, io.grpc.demo.ask.Conversation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "askBidiStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Conversation.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  io.grpc.demo.ask.Conversation.getDefaultInstance()))
              .setSchemaDescriptor(new CommunicatorMethodDescriptorSupplier("askBidiStream"))
              .build();
        }
      }
    }
    return getAskBidiStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommunicatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicatorStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicatorStub>() {
        @java.lang.Override
        public CommunicatorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicatorStub(channel, callOptions);
        }
      };
    return CommunicatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommunicatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicatorBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicatorBlockingStub>() {
        @java.lang.Override
        public CommunicatorBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicatorBlockingStub(channel, callOptions);
        }
      };
    return CommunicatorBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommunicatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommunicatorFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommunicatorFutureStub>() {
        @java.lang.Override
        public CommunicatorFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommunicatorFutureStub(channel, callOptions);
        }
      };
    return CommunicatorFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void searchContent(io.grpc.demo.ask.Message request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Content> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchContentMethod(), responseObserver);
    }

    /**
     */
    default void ask(io.grpc.demo.ask.Conversation request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAskMethod(), responseObserver);
    }

    /**
     */
    default void askStreamReply(io.grpc.demo.ask.Conversation request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAskStreamReplyMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> askBidiStream(
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAskBidiStreamMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Communicator.
   */
  public static abstract class CommunicatorImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CommunicatorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Communicator.
   */
  public static final class CommunicatorStub
      extends io.grpc.stub.AbstractAsyncStub<CommunicatorStub> {
    private CommunicatorStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicatorStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicatorStub(channel, callOptions);
    }

    /**
     */
    public void searchContent(io.grpc.demo.ask.Message request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Content> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchContentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void ask(io.grpc.demo.ask.Conversation request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void askStreamReply(io.grpc.demo.ask.Conversation request,
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAskStreamReplyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> askBidiStream(
        io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getAskBidiStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Communicator.
   */
  public static final class CommunicatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CommunicatorBlockingStub> {
    private CommunicatorBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.demo.ask.Content searchContent(io.grpc.demo.ask.Message request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchContentMethod(), getCallOptions(), request);
    }

    /**
     */
    public io.grpc.demo.ask.Conversation ask(io.grpc.demo.ask.Conversation request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAskMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<io.grpc.demo.ask.Message> askStreamReply(
        io.grpc.demo.ask.Conversation request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAskStreamReplyMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Communicator.
   */
  public static final class CommunicatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<CommunicatorFutureStub> {
    private CommunicatorFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommunicatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommunicatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.demo.ask.Content> searchContent(
        io.grpc.demo.ask.Message request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchContentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<io.grpc.demo.ask.Conversation> ask(
        io.grpc.demo.ask.Conversation request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEARCH_CONTENT = 0;
  private static final int METHODID_ASK = 1;
  private static final int METHODID_ASK_STREAM_REPLY = 2;
  private static final int METHODID_ASK_BIDI_STREAM = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEARCH_CONTENT:
          serviceImpl.searchContent((io.grpc.demo.ask.Message) request,
              (io.grpc.stub.StreamObserver<io.grpc.demo.ask.Content>) responseObserver);
          break;
        case METHODID_ASK:
          serviceImpl.ask((io.grpc.demo.ask.Conversation) request,
              (io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation>) responseObserver);
          break;
        case METHODID_ASK_STREAM_REPLY:
          serviceImpl.askStreamReply((io.grpc.demo.ask.Conversation) request,
              (io.grpc.stub.StreamObserver<io.grpc.demo.ask.Message>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ASK_BIDI_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.askBidiStream(
              (io.grpc.stub.StreamObserver<io.grpc.demo.ask.Conversation>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSearchContentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.demo.ask.Message,
              io.grpc.demo.ask.Content>(
                service, METHODID_SEARCH_CONTENT)))
        .addMethod(
          getAskMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              io.grpc.demo.ask.Conversation,
              io.grpc.demo.ask.Conversation>(
                service, METHODID_ASK)))
        .addMethod(
          getAskStreamReplyMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              io.grpc.demo.ask.Conversation,
              io.grpc.demo.ask.Message>(
                service, METHODID_ASK_STREAM_REPLY)))
        .addMethod(
          getAskBidiStreamMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              io.grpc.demo.ask.Conversation,
              io.grpc.demo.ask.Conversation>(
                service, METHODID_ASK_BIDI_STREAM)))
        .build();
  }

  private static abstract class CommunicatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommunicatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return io.grpc.demo.ask.DialogistProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Communicator");
    }
  }

  private static final class CommunicatorFileDescriptorSupplier
      extends CommunicatorBaseDescriptorSupplier {
    CommunicatorFileDescriptorSupplier() {}
  }

  private static final class CommunicatorMethodDescriptorSupplier
      extends CommunicatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CommunicatorMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommunicatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommunicatorFileDescriptorSupplier())
              .addMethod(getSearchContentMethod())
              .addMethod(getAskMethod())
              .addMethod(getAskStreamReplyMethod())
              .addMethod(getAskBidiStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
