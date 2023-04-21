package ru.hector.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("hello, " + name + " " + surname);

        model.addAttribute("message", "hello, " + name + " " + surname);


        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calc(@RequestParam(value = "arg1",defaultValue = "1") int arg1,
                       @RequestParam(value = "arg2",defaultValue = "1") int arg2,
                       @RequestParam(value = "action",defaultValue = "addition") String action,
                       Model model) {
        double result = 0;
        switch (action) {
            case "multiplication":
                result = arg1 * arg2;
                break;
            case "addition":
                result = arg1 + arg2;
                break;
            case "subtraction":
                result = arg1 - arg2;
                break;
            case "division":
                result = ((double) arg1) / arg2;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
}
