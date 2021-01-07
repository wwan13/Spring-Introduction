package springintroduction.springintroduction.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // localhost:8080/hello url 에서 동작
    @GetMapping("hello")
    public String hello(Model model) {
        // 첫번째 arg : 템플릿에서 데이터를 사용하기 위한 이름
        // 두번째 arg : 템플릿으로 전달할 데이터
        // => template 에서 "hello world" 를 data라는 이름으로 사용 가능
        model.addAttribute("data","hello world");

        // hello.html 로 가서 렌더링
        return "hello";
    }
}
