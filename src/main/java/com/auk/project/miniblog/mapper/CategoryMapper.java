package com.auk.project.miniblog.mapper;

import com.auk.project.miniblog.dto.CategoryDto;
import com.auk.project.miniblog.entity.Category;
import com.auk.project.miniblog.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryMapper implements CustomMapper<Category, CategoryDto> {
    @Override
    public CategoryDto mapToDto(Category entity) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(entity,categoryDto);
        return categoryDto;
    }

    @Override
    public Category mapToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }

    public List<CategoryDto> mapToList(Iterable<Category> categories) {
        List<CategoryDto> categoriesDtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryDto dto = new CategoryDto();
           // dto.setId(category.getId());
            dto.setName(category.getName());
            categoriesDtos.add(dto);
        }
        return categoriesDtos;
    }
}

