package com.auk.project.miniblog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_article",
            joinColumns = @JoinColumn(name = "id_category"),
            inverseJoinColumns = @JoinColumn(name = "id_article"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"id_category", "id_article"})})
    private Set<Article> articles;
}
