package com.springlab.jdbc.service;

import com.springlab.jdbc.domain.Member;
import com.springlab.jdbc.repository.MemberRepositoryV1;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepositoryV1;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException { // SQL Exception 은 JDBC 종속되는 예외이다.
        Member fromMember = memberRepositoryV1.findById(fromId);
        Member toMember = memberRepositoryV1.findById(toId);

        memberRepositoryV1.update(fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepositoryV1.update(toId, toMember.getMoney() + money);
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외 발생");
        }
    }
}
