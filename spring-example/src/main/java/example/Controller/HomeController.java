package example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// django 의 view 와도 비슷한 역할 ?
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
