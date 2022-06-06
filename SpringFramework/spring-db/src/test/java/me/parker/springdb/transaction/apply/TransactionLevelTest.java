package me.parker.springdb.transaction.apply;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Slf4j
@SpringBootTest
@DisplayName("트랜잭션 적용 위치에 따라 어떤 우선순위로 적용되는지 테스트")
public class TransactionLevelTest {

    @Autowired
    private LevelService levelService;

    @Test
    void level_order_test() {
        levelService.write();
        levelService.read();
    }

    @TestConfiguration
    static class TransactionLevelTestConfig {

        @Bean
        public LevelService levelService() {
            return new LevelService();
        }
    }

    @Transactional(readOnly = true)
    static class LevelService {

        @Transactional(readOnly = false)
        public void write() {
            log.info("call write");
            printTransactionInfo();
        }

        public void read() {
            log.info("call read");
            printTransactionInfo();
        }

        private void printTransactionInfo() {
            boolean txActive = TransactionSynchronizationManager.isSynchronizationActive();
            log.info("transaction active = {}", txActive);
            boolean readOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly();
            log.info("transaction readOnly = {}", readOnly);
        }
    }
}
