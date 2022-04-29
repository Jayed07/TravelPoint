package com.travelpoint.service;

import com.travelpoint.model.entity.RegionEntity;
import com.travelpoint.model.entity.enums.RegionName;

import java.util.Map;

public interface RegionService {

    void seedRegions();

    Map<String, String> getAllRegions();

    RegionEntity findByName (RegionName regionName);
}
