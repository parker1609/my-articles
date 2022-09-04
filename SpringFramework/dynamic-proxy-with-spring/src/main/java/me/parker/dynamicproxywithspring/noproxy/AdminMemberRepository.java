package me.parker.dynamicproxywithspring.noproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminMemberRepository implements MemberRepository {

    @Override
    public void save(String name) {
        try {
            log.info("--- 트랜잭션 커밋 시작 ---");

            log.info("어드민 회원 저장, name={}", name);

            log.info("--- 트랜잭션 커밋 완료 ---");
        } catch (Exception e) {
            log.info("--- 트랜잭션 롤백 ---");
        } finally {
            log.info("--- DB 커넥션 자원 반환 ---");
        }
    }
}
