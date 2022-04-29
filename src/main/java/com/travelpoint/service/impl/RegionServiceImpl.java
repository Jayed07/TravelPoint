package com.travelpoint.service.impl;

import com.travelpoint.model.entity.RegionEntity;
import com.travelpoint.model.entity.enums.RegionName;
import com.travelpoint.repository.RegionRepository;
import com.travelpoint.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void seedRegions() {
        if (regionRepository.count() == 0) {

            RegionName[] regionNames = RegionName.values();

            for (RegionName regionName : regionNames) {
                RegionEntity regionEntity = new RegionEntity();
                regionEntity.setName(regionName);
                regionEntity.setDescription("Some " + regionName.toString().toLowerCase() + " region description.");
                regionRepository.save(regionEntity);

            }

        }

    }

    @Override
    public Map<String, String> getAllRegions() {
        Map<String, String> allRegions = new LinkedHashMap<>();

        for (RegionName value : RegionName.values()) {
            RegionEntity regionEntity = regionRepository.findByName(value);
            allRegions.put(regionEntity.getName().toString(), regionEntity.getDescription());

        }

        return allRegions;
    }

    @Override
    public RegionEntity findByName(RegionName regionName) {
        return regionRepository.findByName(regionName);
    }
}
