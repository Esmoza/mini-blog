package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.repository.ArticleRepository;
import com.auk.project.miniblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/blog/")
public class WebController {
    @Autowired
    private ArticleRepository article;

    private ArticleService articleService;


    @GetMapping("list")
    public String showUpdateFormm(Model model) {
        model.addAttribute("articles", article.findAll());

        return "show-articles";
    }

    @GetMapping("form")
    public String showArticleForm(Article articles){
        return "add-articles";
    }

    @PostMapping("add")
    public String addGuest(@Valid Article articles, BindingResult result, Model model) {
        articles.setCreatedAt(LocalDateTime.now());
        articles.setUpdatedAt(LocalDateTime.now());
        articles.setPublished(1);
        if (result.hasErrors()) {
            return "add-articles";
        }

        article.save(articles);
        return "redirect:list";
    }

    @GetMapping("detail/{id}")
    public String showDetails(@PathVariable("id") long id, Model model) {
        Optional<Article> articleobj = Optional.ofNullable(article.findById(id));
        Article article1;
        if(articleobj.isPresent()){
            article1=articleobj.get();
            model.addAttribute("articles", article1);
        }
        return "show-details";

    }

}
