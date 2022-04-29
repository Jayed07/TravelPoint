package com.travelpoint.model.service;

import com.travelpoint.model.entity.CommentEntity;

public class CommentAddServiceModel {

    private String author;
    private String content;
    private CommentEntity commentEntity;

    public CommentAddServiceModel() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommentEntity getCommentEntity() {
        return commentEntity;
    }

    public void setCommentEntity(CommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }
}
