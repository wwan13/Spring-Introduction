package example.Controller;

import example.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/*
* @Controller, @Service, @Repository -> 컴포넌트 스캔 방식으로 자동으로 의존성 주입 ( 스프링 빈에 주입 )
*
* */

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
