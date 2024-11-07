package spring.mvc1.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // key : value
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence =  0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    // private으로 생성 막기
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        // store에 있는 모든 값들을 다 꺼내서 새로운 arrayList에 담아서 넘겨준다.
        // 원본 store 내용을 보호하기 위해서
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }




}
