package me.parker.dynamicproxywithspring.proxy.dynamicproxy.spring;

import lombok.extern.slf4j.Slf4j;
import me.parker.dynamicproxywithspring.repository.AdminMemberRepository;
import me.parker.dynamicproxywithspring.repository.MemberRepository;
import me.parker.dynamicproxywithspring.repository.NormalMemberRepository;
import me.parker.dynamicproxywithspring.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyFactoryClient {

    @Test
    void save_normal_member() {
        String normalMemberName = "PARKER";
        MemberRepository target = new NormalMemberRepository();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TransactionAdvice());
        MemberRepository proxy = (MemberRepository) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(normalMemberName);
    }

    @Test
    void save_admin_member() {
        String adminMemberName = "PARKER_ADMIN";
        MemberRepository target = new AdminMemberRepository();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TransactionAdvice());
        MemberRepository proxy = (MemberRepository) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(adminMemberName);
    }

    @Test
    void save_order() {
        String orderName = "주문01";
        OrderRepository target = new OrderRepository();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TransactionAdvice());
        OrderRepository proxy = (OrderRepository) proxyFactory.getProxy();
        proxyFactory.setProxyTargetClass(true);

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());
        proxy.save(orderName);
    }
}
