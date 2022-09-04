package me.parker.dynamicproxywithspring.proxy.dynamicproxy.jdk;

import lombok.extern.slf4j.Slf4j;
import me.parker.dynamicproxywithspring.repository.AdminMemberRepository;
import me.parker.dynamicproxywithspring.repository.MemberRepository;
import me.parker.dynamicproxywithspring.repository.NormalMemberRepository;
import me.parker.dynamicproxywithspring.repository.OrderRepository;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
class JDKDynamicProxyClient {

    @Test
    void save_normal_member() {
        String normalMemberName = "PARKER";
        MemberRepository target = new NormalMemberRepository();

        TransactionInvocationHandler handler = new TransactionInvocationHandler(target);
        MemberRepository proxy = (MemberRepository) Proxy.newProxyInstance(
                MemberRepository.class.getClassLoader(), new Class[]{MemberRepository.class}, handler);

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(normalMemberName);
    }

    @Test
    void save_admin_member() {
        String adminMemberName = "PARKER_ADMIN";
        MemberRepository target = new AdminMemberRepository();

        TransactionInvocationHandler handler = new TransactionInvocationHandler(target);
        MemberRepository proxy = (MemberRepository) Proxy.newProxyInstance(
                MemberRepository.class.getClassLoader(), new Class[]{MemberRepository.class}, handler);

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(adminMemberName);
    }

    @Test
    void save_order() {
        String orderName = "주문01";
        OrderRepository target = new OrderRepository();

        TransactionInvocationHandler handler = new TransactionInvocationHandler(target);
        OrderRepository proxy = (OrderRepository) Proxy.newProxyInstance(
                OrderRepository.class.getClassLoader(), new Class[]{OrderRepository.class}, handler);

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(orderName);
    }
}