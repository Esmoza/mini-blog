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
    int id;
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    Article article;
    String authorName;
    String authorEmail;
    String commendBody;
    LocalDateTime createdAt;
}
