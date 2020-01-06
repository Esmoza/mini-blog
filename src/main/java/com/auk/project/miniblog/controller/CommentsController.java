package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.dto.CommentDto;
import com.auk.project.miniblog.entity.Article;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.Comment;
import com.auk.project.miniblog.entity.User;
import com.auk.project.miniblog.repository.UserRepository;
import com.auk.project.miniblog.service.ArticleService;
import com.auk.project.miniblog.service.CommentService;
import com.auk.project.miniblog.service.UserService;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    private ArticleService articleService;

    @RequestMapping(value = "addComments", method = RequestMethod.POST)
    public String addComments(Model model, CommentDto commentDto) {
        commentService.save(commentDto);
        model.addAttribute("comments",commentDto);
        return "redirect:list";
    }

//    @RequestMapping(value = "/createComment", method = RequestMethod.POST)
//    public String createNewPost(@Valid Comment comment,
//                                BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "/commentForm";
//
//        } else {
//            commentService.save(comment);
//            return "redirect:/post/" + comment.getUsers();
//        }
//    }

//    @RequestMapping(value = "/commentPost/{id}", method = RequestMethod.GET)
//    public String commentPostWithId(@PathVariable Long id,
//                                    User user,
//                                    Model model) {
//
//        Optional<Article> post = articleService.find();
//
//        if (post.isPresent()) {
//            Optional<User> user = userService.findByUserName(user.get);
//
//            if (user.isPresent()) {
//                Comment comment = new Comment();
//                comment.setUser(user.get());
//                comment.setPost(post.get());
//
//                model.addAttribute("comment", comment);
//
//                return "/commentForm";
//
//            } else {
//                return "/error";
//            }
//
//        } else {
//            return "/error";
//        }
//    }
}
