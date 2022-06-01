package me.parker.springjpapostgresql.repository;

import lombok.extern.slf4j.Slf4j;
import me.parker.springjpapostgresql.containers.PostgresqlTestContainers;
import me.parker.springjpapostgresql.entity.ThisIsVeryLongNameTable;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.PostgreSQLContainer;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ThisIsVeryLongNameTableRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresqlTestContainers.getInstance();

    @Autowired
    private ThisIsVeryLongNameTableRepository thisIsVeryLongNameTableRepository;

    @Test
    void save() {
        ThisIsVeryLongNameTable table = new ThisIsVeryLongNameTable(null, "TEMP");

        ThisIsVeryLongNameTable saved = thisIsVeryLongNameTableRepository.save(table);

        assertThat(saved).isNotNull();
        log.info("{}", saved);
    }

    @Test
    void check_seq_table_name_length() {
        String createdSeqTableName = "this_is_very_long_name_table_this_is_very_long_long_long_long_id_seq";

        log.info("Created Seq Table Name Length: {}", createdSeqTableName.length());
    }
}
