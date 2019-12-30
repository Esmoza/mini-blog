package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.entity.ConfirmationToken;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.ConfirmationTokenRepository;
import com.auk.project.miniblog.repository.UserRepository;
import com.auk.project.miniblog.service.EmailSenderService;
import com.auk.project.miniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @GetMapping("/signup")
    public ModelAndView showSignupForm(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
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

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, User user)
    {

        User existingUser = userRepository.findByEmailIgnoreCase(user.getEmail());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            userService.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getEmail());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("elshaniesmoza@gmail.com");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8082/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailSenderService.sendEmail(mailMessage);

            modelAndView.addObject("email", user.getEmail());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepository.findByEmailIgnoreCase(token.getUser().getEmail());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
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
