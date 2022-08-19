package me.parker.designpattern.sms.templatecallback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackClient {

    @Test
    void send_sms_using_a_service() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Template Callback Pattern.";
        SmsService service = new SmsService();

        service.sendSms(cellphoneNumber, smsContents, (cellphoneNumber1, smsContents1) -> {
            log.info("A 외부 서비스 사용: [{}]에게 '{}' 내용 문자 보내기", cellphoneNumber1, smsContents1);
            return true;
        });
    }

    @Test
    void send_sms_using_b_service() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Template Callback Pattern.";
        SmsService service = new SmsService();

        service.sendSms(cellphoneNumber, smsContents, (cellphoneNumber1, smsContents1) -> {
            log.info("B 외부 서비스 사용: [{}]에게 '{}' 내용 문자 보내기", cellphoneNumber1, smsContents1);
            return true;
        });
    }
}
