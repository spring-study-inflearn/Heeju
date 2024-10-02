package spring.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberServiceTest = new MemberServiceImpl();
    @Test
    void join(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        memberServiceTest.join(member);
        Member findMember = memberServiceTest.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
