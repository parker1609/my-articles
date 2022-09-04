package me.parker.dynamicproxywithspring.repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminMemberRepository implements MemberRepository {

    @Override
    public void save(String name) {
        log.info("어드민 회원 저장, name={}", name);
    }
}
