package com.travelpoint.model.entity;

import com.travelpoint.model.entity.enums.RegionName;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class RegionEntity extends BaseEntity {

    private RegionName name;
    private String description;

    public RegionEntity() {
    }

    @Enumerated(EnumType.STRING)
    public RegionName getName() {
        return name;
    }

    public void setName(RegionName name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
