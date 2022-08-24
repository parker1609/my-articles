package me.parker.designpattern.sms.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject {

    @Override
    public String operation() {
        log.info("RealSubject 호출");

        return "data";
    }
}
