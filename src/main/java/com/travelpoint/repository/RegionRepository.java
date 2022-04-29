package com.travelpoint.repository;

import com.travelpoint.model.entity.RegionEntity;
import com.travelpoint.model.entity.enums.RegionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<RegionEntity, Long> {

    RegionEntity findByName(RegionName name);
}
