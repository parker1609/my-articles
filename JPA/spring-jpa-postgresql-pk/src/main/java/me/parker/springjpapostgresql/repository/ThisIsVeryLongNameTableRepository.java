package me.parker.springjpapostgresql.repository;

import me.parker.springjpapostgresql.entity.ThisIsVeryLongNameTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThisIsVeryLongNameTableRepository extends JpaRepository<ThisIsVeryLongNameTable, Long> {
}
