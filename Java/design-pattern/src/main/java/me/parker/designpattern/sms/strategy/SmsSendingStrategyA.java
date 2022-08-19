package me.parker.designpattern.sms.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmsSendingStrategyA implements SmsSendingStrategy {

    @Override
    public boolean execute(String cellphoneNumber, String smsContents) {
        log.info("A 외부 서비스 사용: [{}]에게 '{}' 내용 문자 보내기", cellphoneNumber, smsContents);
        return true;
    }
}
