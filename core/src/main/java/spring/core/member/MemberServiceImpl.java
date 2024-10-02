package spring.core.member;

public class MemberServiceImpl implements MemberService {
    // npe 없애기 위해 구현체도 설정해줘야한다.
    private final MemberRepository memberRepository
            = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
