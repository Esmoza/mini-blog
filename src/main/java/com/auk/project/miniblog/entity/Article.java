package com.auk.project.miniblog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
<<<<<<< HEAD
<<<<<<< Updated upstream
=======
import java.util.Date;
import java.util.Set;
>>>>>>> Stashed changes
=======
import java.util.Date;
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f

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
<<<<<<< HEAD
<<<<<<< Updated upstream
    @ManyToOne(fetch = FetchType.LAZY)
    private Comment comment;
=======
   @ManyToMany(mappedBy = "articles", cascade = CascadeType.PERSIST)
    private Set<Category> categories;

 // @ManyToOne
   // @JoinColumn(name="articleId", nullable=false)
    //private Comment comment;
>>>>>>> Stashed changes
=======
   // @ManyToOne
   // @JoinColumn(name="articleId", nullable=false)
    //private Comment comment;
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f

}
