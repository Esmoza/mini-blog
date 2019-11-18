package com.auk.project.miniblog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name="articles")
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
//    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
 //   private List<Comment> comments=new ArrayList<>();


 // @ManyToOne
   // @JoinColumn(name="articleId", nullable=false)
    //private Comment comment;



}
