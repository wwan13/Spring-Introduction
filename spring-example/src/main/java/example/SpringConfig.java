package example;

import example.domain.Member;
import example.repository.MemberRepository;
import example.repository.MemoryMemberRepository;
import example.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* 자바 코드로 스프링에 의존성을 부여하는 방법
**/

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
