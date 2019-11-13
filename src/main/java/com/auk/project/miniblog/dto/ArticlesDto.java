package com.auk.project.miniblog.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ArticlesDto {

    private long id;
    private String title;
    private String slug;
    private String content;
    private int published;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
