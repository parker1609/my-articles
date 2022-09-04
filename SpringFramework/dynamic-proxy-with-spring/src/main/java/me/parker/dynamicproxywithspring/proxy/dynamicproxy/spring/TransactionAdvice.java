package me.parker.dynamicproxywithspring.proxy.dynamicproxy.spring;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TransactionAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("Advice parameter: invocation={}", invocation);

        try {
            log.info("--- 트랜잭션 커밋 시작 ---");

            Object result = invocation.proceed();

            log.info("--- 트랜잭션 커밋 완료 ---");
            return result;
        } catch (Exception e) {
            log.info("--- 트랜잭션 롤백 ---");
            throw e;
        } finally {
            log.info("--- DB 커넥션 자원 반환 ---");
        }
    }
}
