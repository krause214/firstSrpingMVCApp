package my.babincev.spring.controllers;

import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            Model model){

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculatorPage(HttpServletRequest request,
                                 Model model){
        Double a = Double.parseDouble(request.getParameter("a"));
        Double b = Double.parseDouble(request.getParameter("b"));
        String action = request.getParameter("action");
        String result;
        switch (action){
            case "multiplication":
                result = a + " * " + b + " = " + Double.toString(a * b);
                break;
            case "addition":
                result = a + " + " + b + " = " + Double.toString(a + b);
                break;
            case "subtraction":
                result = a + " - " + b + " = " + Double.toString(a - b);
                break;
            case "division":
                if (!Double.isInfinite(a / b)){
                    result = a + " / " + b + " = " + Double.toString(a / b);
                    break;
                }
            default:
                result = "Invalid action!";
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
