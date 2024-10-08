package spring.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {
    // interface에만 의존할 수 있게 appconfig로 구체클래스 명시 여기선 생성자주입으로 해당 구체 클래스로 초기화해줌
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository=memberRepository;
        this.discountPolicy=discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 단일책임원칙이 잘 지켜진 경우
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}