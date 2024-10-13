package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

@Configuration  // singleTon을 보장해주는 annotation, 없으면 같은 인스턴스 보장X, memberService 3번 호출
public class AppConfig {
    // 원래는 memberserviceimpl에서
    // private final MemberRespository memberRespository = new MemoryMemberRespository(); 처럼 구현객체를 설정해줬다.
    // 이제는 생성자를 통해서 구현객체를 설정해줘서 impl이 인터페이스에만 의존할 수 있게 DIP 지키게 한다.
    // 이것이 생성자 주입.
/*
bean을 붙여주면 컨테이너에 등록됨
 */
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl
                (memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberService");
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    // 여기서는 쓸 구현체를 명시해서 넣어주고 원래의 orderservicimple에서는
    // 부모의(?) 타입으로 해서 넘겨주기, 인터페이스에만 의존할 수 있게

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(
//                memberRepository(),
//                discountPolicy()
//        );
        return null;
    }
}