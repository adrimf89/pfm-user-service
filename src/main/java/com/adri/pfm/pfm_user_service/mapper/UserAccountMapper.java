package com.adri.pfm.pfm_user_service.mapper;

import com.adri.pfm.pfm_user_service.dto.CreateUserAccountDTO;
import com.adri.pfm.pfm_user_service.dto.UserAccountDTO;
import com.adri.pfm.pfm_user_service.model.UserAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {

    UserAccount toUserAccount(UserAccountDTO userAccountDTO);
    UserAccount toUserAccount(CreateUserAccountDTO createUserAccountDTO);
    UserAccountDTO toUserAccountDTO(UserAccount userAccount);

}
