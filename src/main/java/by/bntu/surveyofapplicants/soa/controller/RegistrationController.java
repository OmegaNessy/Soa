package by.bntu.surveyofapplicants.soa.controller;

import by.bntu.surveyofapplicants.soa.dto.UserDto;
import by.bntu.surveyofapplicants.soa.service.UserService;
import by.bntu.surveyofapplicants.soa.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    private static final String REGISTRATION_PAGE = "registration";
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserDto());
        return REGISTRATION_PAGE;
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserDto userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return REGISTRATION_PAGE;
        }
        if (!userForm.getPassword().equals(userForm.getConfirmedPassword())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return REGISTRATION_PAGE;
        }
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return REGISTRATION_PAGE;
        }

        return "redirect:/admin/users";
    }
}