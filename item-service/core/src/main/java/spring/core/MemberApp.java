package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // (1차) MemberService memberService = new MemberServiceImpl();

        // (2차) appconfig로 memorymemberrepository 쓸거라 설정 (2차)

        /*
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
         */

        // (3차) appconfig에 있는 정보를 다 객체생성한걸 넣어 컨테이너에 넣어줌
        ApplicationContext ac
                = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class );

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);;
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+ findMember.getName());;
    }
}