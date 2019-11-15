package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping("/form")
    public String  addCategories(Category category){
        return "add-categories";

    }
    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "show-categories";
    }

    @PostMapping("add")
    public String addCategory(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-categories";
        }

        categoryRepository.save(category);
        return "redirect:list";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("category", category);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateCategory(@PathVariable("id") long id, @Valid Category category, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "update-student";
        }

        categoryRepository.save(category);
        model.addAttribute("students", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        categoryRepository.delete(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }
}
