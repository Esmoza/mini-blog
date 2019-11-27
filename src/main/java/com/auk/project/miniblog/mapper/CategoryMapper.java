package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoryMapper implements CustomMapper<Category, CategoryDto> {
    @Override
    public CategoryDto mapToDto(Category entity) {
       CategoryDto categoryDto=new CategoryDto();
        BeanUtils.copyProperties(categoryDto,entity);
        return categoryDto;
    }

    @Override
    public Category mapToEntity(CategoryDto categoryDto) {
        Category category=new Category();
        BeanUtils.copyProperties(categoryDto,category);
        return category;
    }
}
