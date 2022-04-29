package com.travelpoint.model.view;

import com.travelpoint.model.entity.RegionEntity;

public class LandmarkViewModel {

    private Long id;
    private String name;
    private String content;
    private String imageUrl;
    private RegionEntity regionEntityEntity;

    public LandmarkViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RegionEntity getRegionEntityEntity() {
        return regionEntityEntity;
    }

    public void setRegionEntityEntity(RegionEntity regionEntityEntity) {
        this.regionEntityEntity = regionEntityEntity;
    }
}
