package com.travelpoint.model.service;

import com.travelpoint.model.entity.enums.RegionName;

public class LandmarkAddServiceModel {

    private String name;
    private String content;
    private String imageUrl;
    private RegionName regionName;

    public LandmarkAddServiceModel() {
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

    public RegionName getRegionName() {
        return regionName;
    }

    public void setRegionName(RegionName regionName) {
        this.regionName = regionName;
    }
}
