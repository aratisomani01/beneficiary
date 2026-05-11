package com.wellsfargo.beneficiary.service;

import com.wellsfargo.beneficiary.dao.BankerRepository;
import com.wellsfargo.beneficiary.dto.LoginRequestDTO;
import com.wellsfargo.beneficiary.dto.LoginResponseDTO;
import com.wellsfargo.beneficiary.model.Banker;
import com.wellsfargo.beneficiary.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final BankerRepository bankerRepository;
    private final PasswordUtil passwordUtil;

    public LoginResponseDTO login(LoginRequestDTO request) {

        log.debug("Login attempt for email: {}", request.getEmail());

        Banker banker = bankerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordUtil.matches(request.getPwd(), banker.getPwd())) {
            log.warn("Invalid password attempt for email: {}", request.getEmail());
            throw new RuntimeException("Invalid email or password");
        }

        log.info("Login successful for banker: {}", banker.getName());
        return new LoginResponseDTO(true, "Login successful", banker.getName());
    }
}