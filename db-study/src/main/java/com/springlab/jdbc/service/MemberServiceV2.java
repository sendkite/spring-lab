package com.springlab.jdbc.service;

import com.springlab.jdbc.domain.Member;
import com.springlab.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 트랜젝션 적용 - 파라미터, 풀 적용 (서비스층이 JDBC 기술에 종속적인 문제)
 */
@Slf4j
@RequiredArgsConstructor
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepositoryV2;

    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Connection con = dataSource.getConnection();
        try {
            con.setAutoCommit(false); // 트랜잭션 시작
            // 비즈니스 로직 수행
            bizLogic(fromId, toId, money, con);
            con.commit();
        } catch (Exception e) {
            con.rollback();
            throw new IllegalStateException(e);
        } finally {
            release(con);
        }
    }

    private void release(Connection con) {
        if (con != null) {
            try {
                con.setAutoCommit(true); // ** 커넥션 풀이 계속 살아있어서 기본 값으로 변경하고 닫아야함
                con.close();
            } catch (Exception e) {
                log.info("error", e);
            }
        }
    }

    private void bizLogic(String fromId, String toId, int money, Connection con) throws SQLException {
        Member fromMember = memberRepositoryV2.findById(con, fromId);
        Member toMember = memberRepositoryV2.findById(con, toId);

        memberRepositoryV2.update(con, fromId, fromMember.getMoney() - money);
        validation(toMember);
        memberRepositoryV2.update(con, toId, toMember.getMoney() + money);
    }

    private void validation(Member toMember) {
        if (toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("이체중 예외");
        }
    }

}
