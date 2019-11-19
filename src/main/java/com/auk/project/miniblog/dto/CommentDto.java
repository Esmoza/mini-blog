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
}
