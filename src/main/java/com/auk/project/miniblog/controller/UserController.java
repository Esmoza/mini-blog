package com.auk.project.miniblog.controller;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping("index")
    public String getView(){
        return "index";
    }

    @GetMapping("login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("registration")
    public String showSignupForm(){
        return "registration";
    }

    @PostMapping("registration")
    public ModelAndView showRegistrationForm(WebRequest request, Model model, @Valid User users, BindingResult result){
        ModelAndView modelAndv=new ModelAndView();
        if (result.hasErrors()) {
            modelAndv.addObject("Please correct the error");
        }

       modelAndv.addObject("user",new User());
      modelAndv.setViewName("registration");
      return modelAndv;
    }

    @PostMapping("signin")
    public String signin(@Valid User user,BindingResult result, Model model){
        if (result.hasErrors()) {
            return "login";
        }

        return "redirect:index";
    }

}
