package com.auk.project.miniblog.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private String summary;
    @NotBlank(message = "Content is mandatory")
    @Column(name="content")
    private String content;
    @Column(name="published")
    private int published;
    @Column(name="createdAt")
    private LocalDateTime createdAt;
    @Column(name="updatedAt")
    private LocalDateTime updatedAt;
    private String[] tags=null;
     private Long categoryId;

//    @OneToMany(mappedBy = "articles", cascade = CascadeType.ALL)
 //   private List<Comment> comments=new ArrayList<>();


 // @ManyToOne
   // @JoinColumn(name="articleId", nullable=false)
    //private Comment comment;

 @ManyToOne
 @JoinColumn(name="category")
 private Category category;

 public Long getCategoryId() {
  return categoryId;
 }

 public void setCategoryId(Long categoryId) {
  this.categoryId = categoryId;
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getSlug() {
  return slug;
 }

 public void setSlug(String slug) {
  this.slug = slug;
 }

 public String getSummary() {
  return summary;
 }

 public void setSummary(String summary) {
  this.summary = summary;
 }

 public String getContent() {
  return content;
 }

 public void setContent(String content) {
  this.content = content;
 }

 public int getPublished() {
  return published;
 }

 public void setPublished(int published) {
  this.published = published;
 }

 public LocalDateTime getCreatedAt() {
  return createdAt;
 }

 public void setCreatedAt(LocalDateTime createdAt) {
  this.createdAt = createdAt;
 }

 public LocalDateTime getUpdatedAt() {
  return updatedAt;
 }

 public void setUpdatedAt(LocalDateTime updatedAt) {
  this.updatedAt = updatedAt;
 }

 public Category getCategory() {
  return category;
 }

 public void setCategory(Category category) {
  this.category = category;
 }

 public String[] getTags() {
  return tags;
 }

 public void setTags(String[] tags) {
  this.tags = tags;
 }
}
