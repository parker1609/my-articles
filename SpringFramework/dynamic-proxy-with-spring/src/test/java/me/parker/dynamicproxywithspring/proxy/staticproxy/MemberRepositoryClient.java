package me.parker.dynamicproxywithspring.proxy.staticproxy;

import me.parker.dynamicproxywithspring.repository.AdminMemberRepository;
import me.parker.dynamicproxywithspring.repository.MemberRepository;
import me.parker.dynamicproxywithspring.repository.NormalMemberRepository;
import org.junit.jupiter.api.Test;

class MemberRepositoryClient {

    @Test
    void save_normal_member() {
        String normalMemberName = "PARKER";

        MemberRepository normalMemberRepository = new NormalMemberRepository();
        MemberRepository proxy = new MemberTransactionProxy(normalMemberRepository);

        proxy.save(normalMemberName);
    }

    @Test
    void save_admin_member() {
        String adminMemberName = "PARKER_ADMIN";

        MemberRepository adminMemberRepository = new AdminMemberRepository();
        MemberRepository proxy = new MemberTransactionProxy(adminMemberRepository);

        proxy.save(adminMemberName);
    }
}