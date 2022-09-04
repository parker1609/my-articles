package me.parker.dynamicproxywithspring.proxy.staticproxy;

import me.parker.dynamicproxywithspring.repository.OrderRepository;
import org.junit.jupiter.api.Test;

public class OrderRepositoryClient {

    @Test
    void save_order() {
        String orderName = "주문01";

        OrderRepository orderRepository = new OrderRepository();
        OrderRepository proxy = new OrderTransactionProxy(orderRepository);

        proxy.save(orderName);
    }
}
