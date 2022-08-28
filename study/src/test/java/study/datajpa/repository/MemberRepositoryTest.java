package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = Member.builder()
                .username("hello")
                .age(31)
                .build();

        Member saveMember = memberRepository.save(member);
        Member found = memberRepository.findById(saveMember.getId()).get();

        assertThat(found.getId()).isEqualTo(saveMember.getId());
        assertThat(found).isEqualTo(saveMember);
    }
}