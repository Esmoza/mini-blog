package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.dto.UserDto;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.UserRepository;
import com.auk.project.miniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/signup")
    public String showSignupForm(){
        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.save(user);
        return "redirect:index";
    }


    @ModelAttribute("userdto")
    public UserDto userRegistrationDto() {
        return new UserDto();
    }

    @GetMapping("/update/{username}")
    public String showUpdateForm(@PathVariable("username") String username, Model model) {
        Optional<User> user = userRepository.findByUsername(username);
        User user1 = null;
        if (user.isPresent()) {
            user1 = user.get();
             System.out.println(user1.getEmail());
        }
        model.addAttribute("user", user1);
        model.addAttribute("user", userService.findByUserName(username));
        return "profile.html";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String username, @Valid User user, BindingResult result,
                             Model model) {

        Optional<User> userOptional = userRepository.findByUsername(username);
        User user1 = null;
        if (userOptional.isPresent()) {
            user1 = userOptional.get();

        }
        if (result.hasErrors()) {
            return "profile";
        }
        user1.setUsername(user.getUsername());
        user1.setEmail(user.getEmail());
        user1.setFirstname(user.getFirstname());
        user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user1.setPhoneNumber(user.getPhoneNumber());
        user1.setLocation(user.getLocation());
        userRepository.save(user1);
        return "profile";
    }

}
