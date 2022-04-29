package com.travelpoint.service;

import com.travelpoint.model.entity.enums.RegionName;
import com.travelpoint.model.service.LandmarkAddServiceModel;
import com.travelpoint.model.view.LandmarkViewModel;

import java.util.List;

public interface LandmarkService {

    void add(LandmarkAddServiceModel landmarkAddServiceModel);

    List<LandmarkViewModel> findLandmarksByRegionName(RegionName regionName);

    LandmarkViewModel findById(Long id);

    void deleteById(Long id);
}
