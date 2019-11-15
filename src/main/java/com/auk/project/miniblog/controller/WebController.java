package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/blog/")
public class WebController {
    @Autowired
    private ArticleRepository article;
     @GetMapping("home")
    public String getView(){
        return "index";
    }
    @GetMapping("list")
    public String showUpdateFormm(Model model) {
        model.addAttribute("articles", article.findAll());

        return "show-articles";
    }
    @GetMapping("profile")
    public String showSignupForm(){
        return "profile";
    }

    @GetMapping("form")
    public String showArticleForm(Article articles){
        return "add-articles";
    }

    @PostMapping("add")
    public String addGuest(@Valid Article articles, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-articles";
        }

        article.save(articles);
        return "redirect:list";
    }

    @GetMapping("detail/{id}")
    public String showDetails(@PathVariable("id") long id, Model model) {
        Optional<Article> articles = article.findById(id);
        model.addAttribute("articles", articles);

        return "show-details";

    }
    @GetMapping("login")
    public String showLoginForm(){
      return "login";
    }

    @GetMapping("signup")
    public String showSignupForm(){
        return "signup";
    }
}
