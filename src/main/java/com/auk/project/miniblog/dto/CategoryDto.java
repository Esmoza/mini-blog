package com.auk.project.miniblog.dto;

import com.auk.project.miniblog.entity.Article;
import lombok.Data;

import java.util.Set;

public class CategoryDto {

        private Long id;
        private String name;
        private String description;
        private Set<ArticlesDto> articles;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public Set<ArticlesDto> getArticles() {
                return articles;
        }

        public void setArticles(Set<ArticlesDto> articles) {
                this.articles = articles;
        }
}
