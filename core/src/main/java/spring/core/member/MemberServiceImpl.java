package spring.core.member;

public class MemberServiceImpl implements MemberService {
    // npe 없애기 위해 구현체도 설정해줘야한다.
    /*  appconfig의 등장으로 interface에만 의존하게 해당 코드 삭제
     private final MemberRepository memberRepository
            = new MemoryMemberRepository();
     */

    /* 클래스가 interface에만 의존할 수 있게 수정 */
    private MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
