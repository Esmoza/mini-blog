package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.repository.UserRepository;
import com.auk.project.miniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
/*
@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    private UserDto userDto;

    private UserService userService;

    @GetMapping("/user/registration/form")
    public String showSignupForm(){
        return "registration";
    }


    @PostMapping("/user/registration")
    public ModelAndView showRegistrationForm(WebRequest request, Model model, @Valid User users,UserDto userDto, BindingResult result){
        ModelAndView modelAndv=new ModelAndView();
        if (result.hasErrors()) {
            modelAndv.addObject("Please correct the error");
        }

        modelAndv.addObject("user",new User());
        modelAndv.setViewName("registration");
        return modelAndv;
    }


    @PostMapping("/user/registration")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        String userName = userDto.getUsername();
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("user", new UserDto());

            return "redirect:login";
        }

        return "re";
    }
}
*/