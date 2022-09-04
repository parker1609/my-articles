package me.parker.dynamicproxywithspring.repository.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class FinalRepository {

    public void save() {
        log.info("final 클래스, 저장 로직");
    }
}
