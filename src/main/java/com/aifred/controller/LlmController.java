package com.aifred.controller;

import com.aifred.dto.MessageDto;
import com.aifred.dto.QuestionRequestDto;
import com.aifred.service.ChatHistoryService;
import com.aifred.service.LlmService;
import com.aifred.util.DateTimeUtil;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.demo.ask.CommunicatorGrpc;
import io.grpc.demo.ask.Content;
import io.grpc.demo.ask.Conversation;
import io.grpc.demo.ask.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/llm")
public class LlmController {

    @Autowired
    private ChatHistoryService chatHistoryService;


    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    LlmService llmService;

    @PostMapping(value = "/askContents")
    public ResponseEntity<QuestionRequestDto> askContents(@RequestBody QuestionRequestDto questionRequestDto) {

        Message.Builder messageBuilder = Message.newBuilder();
        messageBuilder.setText(questionRequestDto.getQuestion());
        messageBuilder.setType("1"); //1: 사용자의 질문
        Message message = messageBuilder.build();

        //TODO:포트정보 프로퍼티에
        //======================================================
        // LLM에 컨텐츠 조회
        //======================================================
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
        CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);
        Content content = blockingStub.searchContent(message);
        String contentText = content.getContent(); //컨텐츠: 약관
        questionRequestDto.setContent(contentText);

        //======================================================
        // DB에 사용자 질문의 대한 대화이력 저장
        //======================================================
        // Conversation 생성
        QuestionRequestDto returnQuestionRequestDto = chatHistoryService.createConversation(questionRequestDto);
        // Content 생성
        Long contentId = chatHistoryService.createContent(contentText);
        returnQuestionRequestDto.setContentId(contentId);
        //  Message 생성
        chatHistoryService.createRequestMessage(returnQuestionRequestDto);

        return new ResponseEntity<QuestionRequestDto>(returnQuestionRequestDto, HttpStatus.OK);
    }

    @PostMapping(value = "/ask", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<String> streamDataPush(@RequestBody QuestionRequestDto questionRequestDto) {
        //======================================================
        // Message 생성
        //======================================================
        Message.Builder messageBuilder = Message.newBuilder();
        messageBuilder.setText(questionRequestDto.getQuestion());
        messageBuilder.setType("3");
        Message message = messageBuilder.build();

        //======================================================
        // Content 생성
        //======================================================
        Content content = Content.newBuilder().setContent(questionRequestDto.getContent()).build();

        //======================================================
        // Message History 생성
        //======================================================
        Long memberId = 1000000000L; //TODO:하드코딩 수정
        //대화 이력조회
        List<Message> messageHistoryList = new ArrayList<Message>();
        if (questionRequestDto.getConversationId() != null) {
            List<MessageDto> messageDtoList = chatHistoryService.getChatHistoryDetail(questionRequestDto.getConversationId());
            for (MessageDto messageDto :messageDtoList) {
                Message.Builder messageHistoryBuilder = Message.newBuilder();
                messageBuilder.setText(questionRequestDto.getQuestion());
                messageBuilder.setType(messageDto.getType());
                messageBuilder.setTime(DateTimeUtil.getDateString(messageDto.getCreatedAt(), "yyyyMMddHHmmss"));
                Message messageHistory = messageBuilder.build();
                messageHistoryList.add(messageHistory);
            }
        }


        //======================================================
        // Conversation 생성
        //======================================================
        Conversation conversation = Conversation
                .newBuilder()
                .addContent(content)
                .setMessage(message)
                .addAllMessageHistory(messageHistoryList)
                .build();

        //======================================================
        // democore 요청하기
        //======================================================
        //TODO:포트정보 프로퍼티에
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
        CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
        CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);

        //======================================================
        // Stream으로 리턴
        //======================================================
        return Flux.create(sink -> {
            Iterator<Message> messageIterator = blockingStub.askStreamReply(conversation);

            Schedulers.boundedElastic().schedule(() -> {
                String text = "";
                while (messageIterator.hasNext()) {
                    Message returnMessage = messageIterator.next();
                    sink.next(returnMessage.getText());
                    while (messageIterator.hasNext()) {
                        Message response = messageIterator.next();
                        sink.next(response.getText());
                        text += response.getText();
                    }

                    //==================================
                    // DB에 사용자 응답에 대한 Message 생성
                    //==================================
                    questionRequestDto.setResponse(text);
                    chatHistoryService.createResponseMessage(questionRequestDto);

                    sink.complete();
                }
            });
        });
    }

    //	@PostMapping(value = "/askContents")
    public ResponseEntity<String> testAskContents(@RequestBody QuestionRequestDto questionRequest) {

        String test =  "소비자가 반드시 알아두어야 할 상품의 주요 특성 보장성보험 이 보험은 질병보장을 주목적으로 하는 보장성보험이며 저축이나 연금수령을 목적으로 가입하시기에 적합하지 않습니다 . 만기 또는 중도해지시 납입한 보험료보다 환급금이 적을 수 있습니다 . 가입한 특약의 경우 보통약관과 보험기간이 다를 수 있습니다 . (특약별 보험기간을 꼼꼼히 확인하시기 바랍니다 ) 사망, 상해, 질병 등 자동갱신형 자동갱신형 상품은 최초가입후 기본계약의 보험기간마다 갱신을 통해 갱신종료 나이 100세(일부담보 만기 상이)까지 보장받을 수 있는 상품 입니다 . - 갱신계약의 보장은 갱신전 계약의 보장이 끝나는 때부터 적용합니다 . - 갱신전 계약에서 기본계약 및 특별약관의 소멸사유가 발생하였을 경 우, 차회 이후의 갱신시에는 해당 기본계약 및 특별약관의 가입이 불 가능합니다 . - 회사는 계약이 아래의 조건을 모두 충족하고 갱신전 계약의 보험기 간이 끝나는 날의 전일까지 계약자로부 터 별도의 의사표시가 없을 때에는 동일한 보장내용으로 자동으로 갱신되는 것으로 합니다 . ∙ 갱신될 계약의 보험기간이 회사가 사업방법서에서 정한 기간내 일 것 ∙ 갱신일에 피보험자의 나이가 회사가 사업방법서에서 정한 나이의 범위 내일 것 ∙ 갱신전 계약의 보험료가 정상적으로 납입완료 되었을 것 - 갱신시 에는 나이증가 및 적용요율의 변동(위험률 변동 등) 등으로 인 해 보험료가 인상될 수 있으며 , 회사는 계약자에게 갱신전 계약의 보 험기간이 끝나기 15일 전까지 갱신 요건, 보장내용 변경내역 , 갱신보 험료 및 갱신 절차 등을 서면(등기우편 등), 전화(음성녹음 ) 또는 전 자문서 (SMS 포함) 등으로 안내해 드립니다 . * 기타 세부적인 내용은 반드시 약관을 참고하시기 바랍니다 . 보험료 변동가능 만기환급금 회사는 이 보험의 기본계약 만기시점의 계약자 적립액을 만기환급금으로 지급하며 , 납입보험료 중 적립부분 순보험료 (적립보험료에서 계약체결비용 및 계약관리비용을 제외한 금액)를 기준으로 공시이율을 적용한 금액으로 , 향후 공시이율의 변경, 계약내용의 변경, 보험료 실제 납입일자 , 중도인출 여부 등에 따라 달라질 수 있습니다 . 적립되는 보험료 없이 보장담보만으로 가입하시는 경우 보험계약 만기시 지급받는 금액(만기환급금 )이 없습니다 . 변동가능 금리연동형 이 보험의 적립부분 순보험료에 적용되는 이율은 매월 변동됩니다 . * 적립부분 순보험료 : 적립보험료에서 부가보험료 (계약체결비용 및 계약관리비용 등)를 제외한 금액 동 이율은 납입한 보험료에서 계약체결 ·유지관리에 필요한 경비 및 위험보장을 위한 보험료 , 특약보험료를 차감한 금액에 대해서만 적용됩니다 . 적용금리 변동 최저보증이율 이 보험의 최저보증이율 은 연복리 0.25% 입니다 . * 최저보증이율 : 자산운용이익률 , 시장금리가 하락하는 경우 회사가 보증하는 적용이율의 최저한도 0.25% 예금자보호 이 보험은 예금자보호법에 따라 예금보험공사가 보호합니다 . 예금자보호 한도는 본 보험회사에 있는 귀하의 모든 예금보호 대상 금융상품의 해약환급금 (또는 만기시 보험금이나 사고보험금 )과 기타 지급금을 합하여 1인당 “최고 5천만원 ”이며, 5천만원을 초과하는 나머지 금액은 보호하지 않습니다 . 지정대리청구 보험사고 (치매 등) 발생으로 본인 스스로 보험금 청구가 현실적으로 어려운 상황이 발생할 경우 보험금을 대신 청구하는 자(보험금 지정 대리청구인 )를 보험가입초기 또는 유지 중에 미리 지정하는 제도 입니다 . * 계약자가 자신을 위한 치매보험 가입하고 치매가 발생한 경우 계약자가 보험금을 직접 청구할 수 없어 보험금 청구가 곤란. 이런 경우에 대비하여 보험금 대리청구인을 미리 지정하면 계약자를 대신하여 보험금을 청구할 수 있음 보험금청구대리 인지정 11 / 152";
        return new ResponseEntity<String>(test, HttpStatus.OK);
    }

    //	@PostMapping(value = "/ask", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<String> testStreamDataPush(@RequestBody QuestionRequestDto questionRequest) {
        String msg = "반갑습니다 무엇을 도와 드릴까요?";
        String[] characters = msg.split("");

        // 문자열 배열을 Flux로 변환하여 push 방식으로 스트림 생성
        return Flux.fromArray(characters); // 1초 간격으로 요소를 전송
    }
}