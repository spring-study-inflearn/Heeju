package spring.core.order;

import org.junit.jupiter.api.Test;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }
}

/* OrderServiceImpl에 수정자 주입으로 OrderServiceImpl에 주입이 되었어도,
   테스트를 할 때는 직접 객체를 생성해서 하는 순수 자바 코드로 하면
   주입이 안되어 NPE가 발생 => @SpringBootTest로 스프링 컨테이너 로드하고 빈들을 자동으로 주입하면은 가능

    @Autowired
    private OrderServiceImpl orderService; // 자동으로 주입받음
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void createOrder() {
        // 의존성이 자동으로 주입된 상태에서 테스트 가능 : 객체 생성은 NO
        Member m = new Member(1L, "heeju", Grade.VIP);
        memberRepository.save(m);
        orderService.createOrder(1L, "itemA", 10000);
    }
 */






