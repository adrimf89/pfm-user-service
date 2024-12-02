package com.adri.pfm.pfm_user_service.repository;

import com.adri.pfm.pfm_user_service.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
