package spring.core;

import spring.core.discount.FixDiscountPolicy;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

public class AppConfig {
    // 원래는 memberserviceimpl에서
    // private final MemberRespository memberRespository = new MemoryMemberRespository(); 처럼 구현객체를 설정해줬다.
    // 이제는 생성자를 통해서 구현객체를 설정해줘서 impl이 인터페이스에만 의존할 수 있게 DIP 지키게 한다.
    // 이것이 생성자 주입.
    public MemberService memberService() {
        return new MemberServiceImpl
                (new MemoryMemberRepository());
    }

    // 여기서는 쓸 구현체를 명시해서 넣어주고 원래의 orderservicimple에서는
    // 부모의(?) 타입으로 해서 넘겨주기, 인터페이스에만 의존할 수 있게
    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new FixDiscountPolicy()
        );
    }
}