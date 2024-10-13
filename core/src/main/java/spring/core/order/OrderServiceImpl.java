package spring.core.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor
@Getter
public class OrderServiceImpl implements OrderService {
    // interface에만 의존할 수 있게 appconfig로 구체클래스 명시 여기선 생성자주입으로 해당 구체 클래스로 초기화해줌

    //생성자 주입일때만 final을 붙일 수 있다. setter 주입일때는 아래 코드 주석처리하면 됨. 현재 없으면 컴파일 오류 떠서 그대로 올림.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired - 생성자 하나일땐 생략가능 : @RequiredArgsConstructor 추가로 해당 생성자 삭제
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
//        System.out.println("cons memberRepository = " + memberRepository);
//        System.out.println("cons discountPolicy = " + discountPolicy);
//        this.memberRepository=memberRepository;
//        this.discountPolicy=discountPolicy;
//    }

    /* 필드주입
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;

    // NPE가 터짐에 따라서 setter를 넣어줌. 그래서 필드에 @Autowired를 지우고 결국은 setter injection이 된다. => 안 쓰게 된다.
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("setter memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("setter discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    } */

    /* setter 주입
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository){
        System.out.println("setter memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy){
        System.out.println("setter discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    } */



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 단일책임원칙이 잘 지켜진 경우
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }


}