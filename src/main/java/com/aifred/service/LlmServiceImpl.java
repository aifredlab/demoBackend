package com.aifred.service;

import com.aifred.dto.QuestionReply;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
public class LlmServiceImpl implements LlmService{

    @Override
    public QuestionReply ask(String quesiton) throws Exception {
        ManagedChannel channel = Grpc.newChannelBuilder("localhost:50051", InsecureChannelCredentials.create()).build();

        try {
//            DemoClient client = new DemoClient(channel);
//            //client.request("이 상품을 가입해서 만기가 되면 보험료 전액 환급이 가능해? 약관");
//            AskReply reply = client.request(quesiton);
//
//            QuestionReply questionReply = new QuestionReply();
//            if (reply == null) {
//                questionReply.setReply("응답오류");
//                questionReply.setAgreementContents("");
//            }
//            else {
//                questionReply.setReply(reply.getAnswer());
//                questionReply.setAgreementContents(reply.getContent());
//            }


            //return questionReply;
            return null;


        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
