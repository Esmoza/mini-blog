package com.auk.project.miniblog.controller;

import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/categories/")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("categoriesForm")
    public String  addCategories(Category category){
        return "../static/pages/category/add-category";

    }
   
    @GetMapping("showForm")
    public String showUpdateForm(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "../static/pages/category/show-categories";
    }

    @PostMapping("addCategory")
    public String addCategory(@Valid Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "../static/pages/category/add-category";
        }

        categoryRepository.save(category);
        return "redirect:showForm";
    }
    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("category", category);
        return "update-categories";
    }

    @PostMapping("update/{id}")
    public String updateCategory(@PathVariable("id") long id, @Valid Category category, BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            category.setId(id);
            return "../static/pages/category/update-categories";
        }

        categoryRepository.save(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "../static/pages/category/show-categories";
    }

    @GetMapping("deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        categoryRepository.delete(category);
        model.addAttribute("categories", categoryRepository.findAll());
        return "redirect:/admin/categories/showForm";
    }
}
