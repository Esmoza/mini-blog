package com.auk.project.miniblog.dto;

import com.auk.project.miniblog.entity.Article;

import java.time.LocalDateTime;
import java.util.Set;

public class CommentDto {

    private  Long id;
    private  String authorName;
    private  String authorEmail;
    private  String commendBody;
    private LocalDateTime createdAt;
    private Set<Article> articles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getCommendBody() {
        return commendBody;
    }

    public void setCommendBody(String commendBody) {
        this.commendBody = commendBody;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
