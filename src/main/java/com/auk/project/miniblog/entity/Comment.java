package com.auk.project.miniblog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< Updated upstream
    private Long id;
    private String name;
    private String authore;
    @OneToMany(mappedBy = "comments" fetch= FetchType.LAZY, cascade = CascadeType.All)
    private List<Article> articleList =new ArrayList<>();
=======
    int id;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    Article article;
    String authorName;
    String authorEmail;
    String commendBody;
    LocalDateTime createdAt;
>>>>>>> Stashed changes
}
