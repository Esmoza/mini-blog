package com.auk.project.miniblog.dto;

import com.auk.project.miniblog.entity.Article;
import lombok.Data;

import java.util.Set;
@Data
public class CategoryDto {

        private Long id;
        private String name;
        private String description;
        private Set<Article> articles;


}
