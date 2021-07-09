package by.teachmeskills.mvc.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index() {
        return "redirect:/products";
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam Optional<String> error) {
        final ModelAndView modelAndView = new ModelAndView("login");
        if (error.isPresent()) {
            modelAndView.addObject("errorMessage", "Error occurred");
        }
        return modelAndView;
    }

}
