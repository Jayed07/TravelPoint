package com.travelpoint.repository;

import com.travelpoint.model.entity.LandmarkEntity;
import com.travelpoint.model.entity.enums.RegionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface LandmarkRepository extends JpaRepository<LandmarkEntity, Long> {
//
//    List<LandmarkEntity> findAllByRegion_Name(RegionName regionName);
//
//    List<LandmarkEntity> findAllByAuthor(String author);
}
