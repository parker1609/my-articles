package me.parker.designpattern.sms.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsService {

    private final SmsSendingStrategy smsSendingStrategy;

    public SmsService(SmsSendingStrategy smsSendingStrategy) {
        this.smsSendingStrategy = smsSendingStrategy;
    }

    public void sendSms(String cellphoneNumber, String smsContents) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        boolean result = smsSendingStrategy.execute(cellphoneNumber, smsContents);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }

    public void sendSms2(String cellphoneNumber, String smsContents,
                         SmsSendingStrategy parameterService) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        boolean result = parameterService.execute(cellphoneNumber, smsContents);

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }
}
