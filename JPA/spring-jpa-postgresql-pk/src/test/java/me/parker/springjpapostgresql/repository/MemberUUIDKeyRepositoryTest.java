package me.parker.springjpapostgresql.repository;

import lombok.extern.slf4j.Slf4j;
import me.parker.springjpapostgresql.containers.PostgresqlTestContainers;
import me.parker.springjpapostgresql.entity.MemberUUIDKey;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberUUIDKeyRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlTestContainers.getInstance();

    @Autowired
    private MemberUUIDKeyRepository memberUUIDKeyRepository;

    @Test
    @Rollback(value = false) // commit 실행으로 insert 쿼리까지 보기 위함.
    void save() {
        // id = null 삽입 시, ids for this class must be manually assigned before calling save() 에러 발생
        MemberUUIDKey member = new MemberUUIDKey(UUID.randomUUID(), "parker", "parker@gmail.com");

        MemberUUIDKey saved = memberUUIDKeyRepository.save(member);

        assertThat(saved).isNotNull();
        log.info("{}", saved);
    }
}
