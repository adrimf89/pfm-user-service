package com.adri.pfm.pfm_user_service.dto;

import java.util.List;

public record UserAccountDTO(long id, String username, String password, List<RoleDTO> roles) {
}
