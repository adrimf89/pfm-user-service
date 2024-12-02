package com.adri.pfm.pfm_user_service.dto;

import java.util.List;

public record RoleDTO(long id, String name, String description, List<PermissionDTO> permissions) {
}
