package my.babincev.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello_world")
    public String sayHello(){
        return "hello_world";
    }
}
