package com.springlab.jdbc.service;

import com.springlab.jdbc.domain.Member;
import com.springlab.jdbc.repository.MemberRepositoryV2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.SQLException;

import static com.springlab.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberServiceV2Test {

    private MemberRepositoryV2 memberRepositoryV2;
    private MemberServiceV2 memberServiceV2;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        memberRepositoryV2 = new MemberRepositoryV2(dataSource);
        memberServiceV2 = new MemberServiceV2(dataSource, memberRepositoryV2);
    }

    @AfterEach
    void after() throws SQLException {
        memberRepositoryV2.delete("memberA");
        memberRepositoryV2.delete("memberB");
        memberRepositoryV2.delete("ex");
    }

    @DisplayName("정상 이체")
    @Test
    void accountTransfer() throws SQLException {
        // given
        Member memberA = new Member("memberA", 10000);
        Member memberB = new Member("memberB", 10000);
        memberRepositoryV2.save(memberA);
        memberRepositoryV2.save(memberB);
        // when
        memberServiceV2.accountTransfer(memberA.getMemberId(), memberB.getMemberId(), 2000);
        // then
        Member findMemberA = memberRepositoryV2.findById(memberA.getMemberId());
        Member findMemberB = memberRepositoryV2.findById(memberB.getMemberId());
        assertThat(findMemberA.getMoney()).isEqualTo(8000);
        assertThat(findMemberB.getMoney()).isEqualTo(12000);
    }

    @DisplayName("이체중 예외 발생")
    @Test
    void accountTransferEx() throws SQLException {
        // given
        Member memberA = new Member("memberA", 10000);
        Member memberEx = new Member("ex", 10000);
        memberRepositoryV2.save(memberA);
        memberRepositoryV2.save(memberEx);
        // when
        assertThatThrownBy(() ->
                memberServiceV2.accountTransfer(memberA.getMemberId(), memberEx.getMemberId(), 2000))
                .isInstanceOf(IllegalStateException.class);
        // then
        Member findMemberA = memberRepositoryV2.findById(memberA.getMemberId());
        Member findMemberEx = memberRepositoryV2.findById(memberEx.getMemberId());

        assertThat(findMemberA.getMoney()).isEqualTo(10000);
        assertThat(findMemberEx.getMoney()).isEqualTo(10000);
    }
}