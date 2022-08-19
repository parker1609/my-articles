package me.parker.designpattern.sms.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyClient {

    @Test
    void send_sms_using_a_service() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Strategy Pattern.";
        SmsSendingStrategy strategyA = new SmsSendingStrategyA();
        SmsService service = new SmsService(strategyA);

        service.sendSms(cellphoneNumber, smsContents);
    }

    @Test
    void send_sms_using_a_service_anonymous_class() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Strategy Pattern.";
        SmsService service = new SmsService(new SmsSendingStrategy() {
            @Override
            public boolean execute(String cellphoneNumber, String smsContents) {
                log.info("A 외부 서비스 사용: [{}]에게 '{}' 내용 문자 보내기", cellphoneNumber, smsContents);
                return true;
            }
        });

        service.sendSms(cellphoneNumber, smsContents);
    }

    @Test
    void send_sms_using_a_service_lambda() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Strategy Pattern.";
        SmsService service = new SmsService((cellphoneNumber1, smsContents1) -> {
            log.info("A 외부 서비스 사용: [{}]에게 '{}' 내용 문자 보내기", cellphoneNumber1, smsContents1);
            return true;
        });

        service.sendSms(cellphoneNumber, smsContents);
    }
}
