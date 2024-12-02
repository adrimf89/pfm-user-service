package com.adri.pfm.pfm_user_service.controller;

import com.adri.pfm.pfm_user_service.dto.CreateUserAccountDTO;
import com.adri.pfm.pfm_user_service.dto.UserAccountDTO;
import com.adri.pfm.pfm_user_service.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user-accounts")
public class UserController {

    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<UserAccountDTO> createCategory(@RequestBody CreateUserAccountDTO createUserAccountDTO) {
        return ResponseEntity.ok(userAccountService.createUserAccount(createUserAccountDTO));
    }

    @GetMapping("/{userAccountId}")
    public ResponseEntity<UserAccountDTO> findById(@PathVariable long userAccountId) {
        return ResponseEntity.ok(userAccountService.findByUserAccountId(userAccountId));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserAccountDTO> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userAccountService.findByUserAccountUsername(username));
    }
}
