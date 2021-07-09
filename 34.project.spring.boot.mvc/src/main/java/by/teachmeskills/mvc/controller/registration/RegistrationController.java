package by.teachmeskills.mvc.controller.registration;

import by.teachmeskills.mvc.model.auth.RegistrationModel;
import by.teachmeskills.mvc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @GetMapping
    public String registration() {
        return "auth/registration";
    }

    @ModelAttribute("registrationForm")
    public RegistrationModel registrationModel() {
        return new RegistrationModel();
    }

    @PostMapping
    public String register(@ModelAttribute("registrationForm") RegistrationModel registrationModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/login?error";
        }
        userService.saveUser(registrationModel);
        return "redirect:/login";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
