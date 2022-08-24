package me.parker.designpattern.sms.decorator;

import me.parker.designpattern.sms.strategy.SmsSendingStrategy;
import me.parker.designpattern.sms.strategy.SmsSendingStrategyA;
import org.junit.jupiter.api.Test;

class DecoratorClient {

    @Test
    void success_sending_sms() {
        SmsSendingStrategy smsSendingStrategy = new SmsSendingStrategyA();
        // 필터 설정
        NotificationFilter commonFiler = new CommonFilter();
        NotificationFilter smsFilter = new SmsFilterDecorator(commonFiler);

        // 문자 알림 데이터 설정
        NotificationRequest request = new NotificationRequest("NORMAL", "010-1111-2222", "Hello!");

        // SmsService 생성
        SmsService service = new SmsService(smsSendingStrategy, smsFilter);

        service.sendSms(request);
    }

    @Test
    void fail_sending_sms_when_invalid_member_status() {
        SmsSendingStrategy smsSendingStrategy = new SmsSendingStrategyA();
        // 필터 설정
        NotificationFilter commonFiler = new CommonFilter();
        NotificationFilter smsFilter = new SmsFilterDecorator(commonFiler);

        // 문자 알림 데이터 설정
        NotificationRequest request = new NotificationRequest("INVALID", "010-1111-2222", "Hello!");

        // SmsService 생성
        SmsService service = new SmsService(smsSendingStrategy, smsFilter);

        service.sendSms(request);
    }

    @Test
    void fail_sending_sms_when_invalid_cellphone_number() {
        SmsSendingStrategy smsSendingStrategy = new SmsSendingStrategyA();
        // 필터 설정
        NotificationFilter commonFiler = new CommonFilter();
        NotificationFilter smsFilter = new SmsFilterDecorator(commonFiler);

        // 문자 알림 데이터 설정
        NotificationRequest request = new NotificationRequest("NORMAL", "02-1111-2222", "Hello!");

        // SmsService 생성
        SmsService service = new SmsService(smsSendingStrategy, smsFilter);

        service.sendSms(request);
    }
}