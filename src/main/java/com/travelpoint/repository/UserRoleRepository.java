package com.travelpoint.repository;

import com.travelpoint.model.entity.UserRoleEntity;
import com.travelpoint.model.entity.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByRole(UserRole role);
}
