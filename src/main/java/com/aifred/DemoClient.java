package com.aifred;

import io.grpc.*;
import io.grpc.demo.ask.*;
import io.grpc.stub.StreamObserver;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoClient {
    private static final Logger logger = Logger.getLogger(DemoClient.class.getName());
    private final AskerGrpc.AskerBlockingStub blockingStub;
    public DemoClient(Channel channel) {
        blockingStub = AskerGrpc.newBlockingStub(channel);
    }



    public AskReply request(String ask) {
        AskRequest request = AskRequest.newBuilder().setQuestion(ask).build();
        AskReply response = null;
        try {
            response = blockingStub.ask(request);

            //System.out.println("### resp = " + response.getAnswer() + ", " + response.getContent());
            logger.info("Answer : " + response.getAnswer());
            return response;
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());

        }

        return response;
    }

    public void requestStream(String ask) {
        Content content = Content.newBuilder().setContent("test").build();
        Message message = Message.newBuilder().setText("messageTest").build();

        Conversation conversation = Conversation
                .newBuilder()
                //.setContent(0, content)
                .setMessage(message)
                .build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

        CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
        CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);

        Iterator<Conversation> iter = blockingStub.askStreamReply(conversation);


        while (iter.hasNext()) {
            Conversation response = iter.next();
            System.out.println("Received response: " + response);
        }

        channel.shutdown();




//        stub.askStreamReply(request, new StreamObserver<AskReply>() {
//            @Override
//            public void onNext(AskReply value) {
//                System.out.println("onNext() 시작");
//                System.out.println(value.getAnswer());
//                System.out.println("onNext() 끝");
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("에러발생");
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("끝");
//            }
//        });

        //System.out.println("=============ddddddddddddd====================");
    }


    public static void main(String[] args) throws Exception {
        ManagedChannel channel = Grpc.newChannelBuilder("localhost:50051", InsecureChannelCredentials.create()).build();

        try {
            System.out.println("=============시작====================");
            DemoClient client = new DemoClient(channel);
            //client.request("이 상품을 가입해서 만기가 되면 보험료 전액 환급이 가능해? 약관");
            client.requestStream("이 상품을 가입해서 만기가 되면 보험료 전액 환급이 가능해? 약관");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
        System.out.println("=============끝====================");
    }
}