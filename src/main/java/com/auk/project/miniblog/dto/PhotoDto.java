package com.auk.project.miniblog.dto;

public class PhotoDto {

    private Long id;
    private String photographer;
    private String path;
    private String fileName;
    private String comments;
    private ArticlesDto articlesDto;
    private Long artcicleId;

    public PhotoDto() {
    }

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

    public ArticlesDto getArticlesDto() {
        return articlesDto;
    }

    public void setArticlesDto(ArticlesDto articlesDto) {
        this.articlesDto = articlesDto;
    }
}
