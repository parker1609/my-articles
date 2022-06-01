package me.parker.springjpapostgresql.repository;

import me.parker.springjpapostgresql.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
