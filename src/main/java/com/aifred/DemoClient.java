package com.aifred;

import io.grpc.*;
import io.grpc.demo.ask.AskReply;
import io.grpc.demo.ask.AskRequest;
import io.grpc.demo.ask.AskerGrpc;

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

    public static void main(String[] args) throws Exception {
        ManagedChannel channel = Grpc.newChannelBuilder("localhost:50051", InsecureChannelCredentials.create()).build();

        try {
            DemoClient client = new DemoClient(channel);
            client.request("이 상품을 가입해서 만기가 되면 보험료 전액 환급이 가능해? 약관");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}