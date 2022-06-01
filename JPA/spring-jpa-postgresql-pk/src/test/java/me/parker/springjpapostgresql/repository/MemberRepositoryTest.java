package me.parker.springjpapostgresql.repository;

import lombok.extern.slf4j.Slf4j;
import me.parker.springjpapostgresql.containers.PostgresqlTestContainers;
import me.parker.springjpapostgresql.entity.Member;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlTestContainers.getInstance();

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Rollback(value = false) // commit 실행으로 insert 쿼리까지 보기 위함.
    void save() {
        Member member = new Member(null, "parker", "parker@gmail.com");

        Member saved = memberRepository.save(member);

        assertThat(saved).isNotNull();
        log.info("{}", saved);
    }
}
