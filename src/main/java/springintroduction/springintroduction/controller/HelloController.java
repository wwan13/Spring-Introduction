package springintroduction.springintroduction.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    // http 통신 방식을 이용해 문자만 전달
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello" + name;
    }

    // json 으로 데이터 전달 (API)
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);

        // hello 객체를 json 변환 (jackson library) 를 통해 json 을 변환 한 후 클라이언트에 전달
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}