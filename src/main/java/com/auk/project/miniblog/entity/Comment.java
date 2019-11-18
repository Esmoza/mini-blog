package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String authorName;
    private  String authorEmail;
    private  String commendBody;
    private  LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "comment_article",
            joinColumns = @JoinColumn(name = "id_comment"),
            inverseJoinColumns = @JoinColumn(name = "id_article"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_comment", "id_article"})})
    private Set<Article> articles;
 //   @ManyToOne(fetch = FetchType.LAZY)
 //   @JoinColumn(name = "article_id")
  //  private  Article article;

   // @OneToMany(mappedBy = "comments" fetch= FetchType.LAZY, cascade = CascadeType.All)
  //  private List<Article> articleList =new ArrayList<>();

}
