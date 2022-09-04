package me.parker.dynamicproxywithspring.repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NormalMemberRepository implements MemberRepository {

    @Override
    public void save(String name) {
        log.info("일반 회원 저장, name={}", name);
    }
}
