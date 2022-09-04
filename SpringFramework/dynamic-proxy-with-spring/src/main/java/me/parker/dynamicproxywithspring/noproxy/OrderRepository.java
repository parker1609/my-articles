package me.parker.dynamicproxywithspring.noproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderRepository {

    public void save(String name) {
        log.info("주문 저장, name={}", name);
    }
}
