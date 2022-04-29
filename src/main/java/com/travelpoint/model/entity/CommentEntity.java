package com.travelpoint.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private String author;
    private String content;
    private LandmarkEntity landmarkEntity;

    public CommentEntity() {
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

    @ManyToOne
    public LandmarkEntity getLandmarkEntity() {
        return landmarkEntity;
    }

    public void setLandmarkEntity(LandmarkEntity landmarkEntity) {
        this.landmarkEntity = landmarkEntity;
    }
}
