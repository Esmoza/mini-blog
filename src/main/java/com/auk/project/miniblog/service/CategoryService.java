package com.auk.project.miniblog.service;

import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.mapper.CategoryMapper;
import com.auk.project.miniblog.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDto> findAll(){
        return categoryMapper.mapToList(categoryRepository.findAll());

    }
    public Category find(Long id) {
       Optional<Category> category = categoryRepository.findById(id);
        Category category1 = null;
        if (category.isPresent()) {
            category1 = category.get();
        }
        return category1;

    }
}
