package com.auk.project.miniblog.controller;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("signup")
    public String showSignupForm(){
        return "signup";
    }

    @PostMapping("register")
    public String signup(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }

        userRepository.save(user);
        return "index";
    }
  /*  @PostMapping("login")
    public String login(@ModelAttribute(name="loginForm") User user, Model model){
      String username=showLoginForm();
    }

   */
  @GetMapping("users")
  public List<User> userList(){
      return this.userRepository.findAll();
  }
}
