package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.dto.CommentAndUserDto;
import com.auk.project.miniblog.dto.CommentDto;
import com.auk.project.miniblog.dto.UserUpdatePasswordDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.Comment;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.UserRepository;
import com.auk.project.miniblog.service.ArticleService;
import com.auk.project.miniblog.service.CommentService;
import com.auk.project.miniblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    private ArticleService articleService;

    @GetMapping("/comments/addComments")
    public String showArticleForm(Model model) {
        model.addAttribute("commentDto", new CommentAndUserDto());
        return "/show-details";
    }

    @PostMapping("/comments/addComments")
    public String addComm(Model model, @Valid CommentAndUserDto commentAndUserDto, BindingResult result) {
        if (result.hasErrors()) {
            return "show-details";
        }
        commentService.save(commentAndUserDto);
        model.addAttribute("commentDto", commentAndUserDto);
        return "/show-details";
    }
}