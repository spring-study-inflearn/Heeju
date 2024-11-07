package spring.mvc1.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    // 순서가 보장이 안되면 안되니까 꼭 넣어주기
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("heeju", 23);
        //when
        Member savedMember = memberRepository.save(member);
        //then
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);

    }

    @Test
    void findAll(){
        //given
        Member m1 = new Member("m1", 22);
        Member m2 = new Member("m2", 23);

        memberRepository.save(m1);
        memberRepository.save(m2);

        // when
        List<Member> result = memberRepository.findAll();
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(m1, m2);
    }
}