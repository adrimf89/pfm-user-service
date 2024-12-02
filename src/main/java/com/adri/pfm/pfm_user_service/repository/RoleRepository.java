package com.adri.pfm.pfm_user_service.repository;

import com.adri.pfm.pfm_user_service.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
