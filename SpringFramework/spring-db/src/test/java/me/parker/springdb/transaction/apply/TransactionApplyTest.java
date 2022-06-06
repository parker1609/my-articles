package me.parker.springdb.transaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@DisplayName("트랜잭션이 정상적으로 적용되는지 확인하는 테스트")
public class TransactionApplyTest {

    @Autowired
    private BasicService basicService;

    @Test
    void proxy_check() {
        log.info("AOP class = {}", basicService.getClass());
        assertThat(AopUtils.isAopProxy(basicService)).isTrue();
    }

    @Test
    void transaction_check() {
        basicService.applyTransaction();
        basicService.applyNonTransaction();
    }

    @TestConfiguration
    static class TransactionApplyTestConfig {

        @Bean
        public BasicService basicService() {
            return new BasicService();
        }
    }

    static class BasicService {

        @Transactional
        public void applyTransaction() {
            log.info("call applyTransaction");
            boolean txActive = TransactionSynchronizationManager.isSynchronizationActive();
            log.info("transaction active = {}", txActive);
        }

        public void applyNonTransaction() {
            log.info("call applyNonTransaction");
            boolean txActive = TransactionSynchronizationManager.isSynchronizationActive();
            log.info("transaction active = {}", txActive);
        }
    }
}
