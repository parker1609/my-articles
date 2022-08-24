package me.parker.designpattern.sms.decorator;

import lombok.extern.slf4j.Slf4j;
import me.parker.designpattern.sms.strategy.SmsSendingStrategy;

@Slf4j
public class SmsService {

    private final SmsSendingStrategy smsSendingStrategy;
    private final NotificationFilter notificationFilter;

    public SmsService(SmsSendingStrategy smsSendingStrategy, NotificationFilter notificationFilter) {
        this.smsSendingStrategy = smsSendingStrategy;
        this.notificationFilter = notificationFilter;
    }

    public void sendSms(NotificationRequest request) {
        log.info("문자 발송 시작");
        long startTime = System.currentTimeMillis();

        if (!notificationFilter.canSend(request)) {
            log.info("문자를 발송할 수 없는 상태입니다.");
            return;
        }

        boolean result = smsSendingStrategy.execute(request.getCellphoneNumber(), request.getSmsContents());

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("문자 발송 결과: 성공 여부 = {}, 소요 시간 = {}ms", result, resultTime);
    }
}
