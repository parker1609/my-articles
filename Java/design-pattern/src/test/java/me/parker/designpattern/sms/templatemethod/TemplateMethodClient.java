package me.parker.designpattern.sms.templatemethod;

import org.junit.jupiter.api.Test;

public class TemplateMethodClient {

    @Test
    void send_sms_using_a_service() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Template Method Pattern.";
        SmsTemplateService service = new ASmsService();

        service.sendSms(cellphoneNumber, smsContents);
    }

    @Test
    void send_sms_using_b_service() {
        String cellphoneNumber = "010-1111-2222";
        String smsContents = "Hello! Template Method Pattern.";
        SmsTemplateService service = new BSmsService();

        service.sendSms(cellphoneNumber, smsContents);
    }
}
