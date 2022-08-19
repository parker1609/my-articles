package me.parker.designpattern.sms.templatecallback;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService {

    public void sendSms(String cellphoneNumber, String smsContents,
                        SmsSendingCallback callback) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        boolean result = callback.send(cellphoneNumber, smsContents);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }
}
