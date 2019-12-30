package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.ArticlesDto;
import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.repository.ArticleRepository;
import com.auk.project.miniblog.service.ArticleService;
import com.auk.project.miniblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog/")
public class ArticleController {
    @Autowired
    private ArticleRepository article;

    @Autowired
    private ArticleService articleService;

    @Autowired
    public CategoryService categoryService;

    @GetMapping("form")
    public String showArticleForm(Article articles, Model model, Category category){
        List<CategoryDto> categories=categoryService.findAll();
        model.addAttribute("categories",categories);
        return "add-articles";
    }

    @GetMapping("list")
    public String findAll(Model model) {
        model.addAttribute("articles", articleService.findAll());

        return "show-articles";
    }

   @GetMapping("post")
    public String showPost(Model model) {
        model.addAttribute("articles", article.findAll());

        return "posts";
    }


    @RequestMapping(value = "addArticles", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public String addArticle(@Valid ArticlesDto articlesDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-articles";
        }
        articleService.save(articlesDto);
        return "redirect:list";
    }

    @GetMapping("detail/{slug}")
    public String showDetails(@PathVariable("slug") String slug, Model model) {
        model.addAttribute("articles", articleService.find(slug));
        return "show-details";
    }

    @PostMapping("uploadImage")
   public String uploadImage(@RequestParam("imageFile")MultipartFile imageFile)throws Exception{
        try{
            articleService.saveImage(imageFile);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error saving photo");
        }
        return "redirect:list";
   }

}
