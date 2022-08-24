package me.parker.designpattern.sms.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxySubject implements Subject {

    private Subject target;
    private String cacheValue;

    public CacheProxySubject(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("캐시 프록시 호출");

        if (cacheValue == null) {
            log.info("캐시 값이 비어있으므로, 새로 생성");
            cacheValue = target.operation();
        }

        return cacheValue;
    }
}
