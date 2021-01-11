package springintroduction.springintroduction.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    // localhost:8080/hello url 에서 동작
    @GetMapping("hello")
    public String hello(Model model) {
        // 첫번째 arg : 템플릿에서 데이터를 사용하기 위한 이름
        // 두번째 arg : 템플릿으로 전달할 데이터
        // => template 에서 "hello world" 를 data 라는 이름으로 사용 가능
        model.addAttribute("data","hello world");

        // resources/templates/hello.html 로 데이터 전달
        return "hello";
    }

    // GetMapping 의 parameter == 이 뷰가 동작할 url 주소를
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {

        model.addAttribute("name",name);

        // return 값은 이 동작을 수행해줄 .html 파일의 이름을 넣어줘야함
        String file_name = "hello-template";
        return file_name;
    }
}