package me.parker.springjpapostgresql.repository;

import me.parker.springjpapostgresql.entity.MemberUUIDKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberUUIDKeyRepository extends JpaRepository<MemberUUIDKey, Long> {
}
