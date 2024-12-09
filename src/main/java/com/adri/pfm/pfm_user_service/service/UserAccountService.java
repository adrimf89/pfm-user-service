package com.adri.pfm.pfm_user_service.service;

import com.adri.pfm.pfm_user_service.dto.CreateUserAccountDTO;
import com.adri.pfm.pfm_user_service.dto.UserAccountDTO;
import com.adri.pfm.pfm_user_service.exception.ResourceNotFoundException;
import com.adri.pfm.pfm_user_service.mapper.UserAccountMapper;
import com.adri.pfm.pfm_user_service.model.UserAccount;
import com.adri.pfm.pfm_user_service.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final UserAccountMapper userAccountMapper;
    private final UserAccountRepository userAccountRepository;

    public UserAccountDTO createUserAccount(CreateUserAccountDTO createUserAccountDTO) {
        log.info("Creating new user account for username {}",
                createUserAccountDTO.username());
        UserAccount userAccount = userAccountMapper.toUserAccount(createUserAccountDTO);
        userAccount = userAccountRepository.save(userAccount);
        return userAccountMapper.toUserAccountDTO(userAccount);
    }

    public UserAccountDTO findByUserAccountId(long userAccountId) {
        log.info("Find user account by id {}", userAccountId);
        Optional<UserAccount> result = userAccountRepository.findById(userAccountId);
        return result.map(userAccountMapper::toUserAccountDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User account not found for id " + userAccountId));
    }

    public UserAccountDTO findByUserAccountUsername(String username) {
        log.info("Find user account by username {}", username);
        Optional<UserAccount> result = userAccountRepository.findByUsername(username);
        return result.map(userAccountMapper::toUserAccountDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User account not found for username "+username));
    }
}
