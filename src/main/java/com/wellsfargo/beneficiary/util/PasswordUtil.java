package com.wellsfargo.beneficiary.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {

  public boolean matches(String rawPassword, String hashedPassword) {
        return rawPassword.equalsIgnoreCase(hashedPassword);
    }

}