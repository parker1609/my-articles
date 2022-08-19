package me.parker.designpattern.sms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService {

    public void sendSms(String cellphoneNumber, String smsContents) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        ASmsSendingService aService = new ASmsSendingService();
        // 중간 로직 생략...
        boolean result = aService.send(cellphoneNumber, smsContents);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }

    public void sendSmsB(String cellphoneNumber, String smsContents) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        BSmsSendingService bService = new BSmsSendingService();
        // 중간 로직 생략...
        boolean result = bService.send(cellphoneNumber, smsContents);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }
}
