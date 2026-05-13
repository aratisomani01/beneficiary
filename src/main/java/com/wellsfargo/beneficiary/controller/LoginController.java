package com.wellsfargo.beneficiary.controller;

import com.wellsfargo.beneficiary.dto.LoginRequestDTO;
import com.wellsfargo.beneficiary.dto.LoginResponseDTO;
import com.wellsfargo.beneficiary.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        log.info("Login request received for email: {}", request.getEmail());
        LoginResponseDTO response = loginService.login(request);
        return ResponseEntity.ok(response);
    }
}