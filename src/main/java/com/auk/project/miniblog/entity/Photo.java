package com.auk.project.miniblog.entity;

import com.auk.project.miniblog.dto.ArticlesDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    private String photographer;
    private String path;
    private String fileName;
    private String comments;
    private Long artcicleId;
    public Photo() {
    }

    @ManyToOne
    private Article articles;

    public Long getArtcicleId() {
        return artcicleId;
    }

    public void setArtcicleId(Long artcicleId) {
        this.artcicleId = artcicleId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhotographer() {
        return photographer;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Article getArticles() {
        return articles;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }
}
