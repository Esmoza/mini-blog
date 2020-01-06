package com.auk.project.miniblog.controller.admin;

import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.service.ArticleService;
import com.auk.project.miniblog.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard/")
public class DashboardController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private PhotoService photoService;
    @GetMapping("admin")
    public String dashboard(){
      return "/admin/admin-templates";
    }
    @GetMapping("list")
    public String findAll(Model model) {
        model.addAttribute("articles", articleService.findAll());

        return "../static/pages/tables/data";
    }

    @GetMapping("data/{slug}")
    public String showDetails(@PathVariable("slug") String slug, Model model, Article article) {
        model.addAttribute("articles", articleService.find(slug));
        model.addAttribute("photo", photoService.findByPost(article));
        return "redirect:/dashboard/list";
    }

}
