package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

import static java.util.Calendar.DATE;


@Data
@Table(name="articles")
@Entity
public class Article {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title  is mandatory")
    @Column(name="title")
    private String title;
    @Column(name="slug")
    private String slug;
    @NotBlank(message = "Content is mandatory")
    @Column(name="content")
    private String content;
    @Column(name="published")
    private int published;
    @Column(name="createdAt")
    private LocalDateTime createdAt;
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;

}
