package com.auk.project.miniblog.dto;

import java.time.LocalDateTime;

public class CommentAndUserDto {

    private  String authorName;
    private  String authorEmail;
    private  String commendBody;
    private LocalDateTime createdAt;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getCommendBody() {
        return commendBody;
    }

    public void setCommendBody(String commendBody) {
        this.commendBody = commendBody;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
