package me.parker.dynamicproxywithspring.proxy.staticproxy;

import lombok.extern.slf4j.Slf4j;
import me.parker.dynamicproxywithspring.repository.OrderRepository;

@Slf4j
public class OrderTransactionProxy extends OrderRepository {

    private OrderRepository target;

    public OrderTransactionProxy(OrderRepository target) {
        this.target = target;
    }

    @Override
    public void save(String name) {
        log.info("Target Class={}", target.getClass());

        try {
            log.info("--- 트랜잭션 커밋 시작 ---");

            target.save(name);

            log.info("--- 트랜잭션 커밋 완료 ---");
        } catch (Exception e) {
            log.info("--- 트랜잭션 롤백 ---");
        } finally {
            log.info("--- DB 커넥션 자원 반환 ---");
        }
    }
}
