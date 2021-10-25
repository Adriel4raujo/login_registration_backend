package com.adriel.loginregistrationbackend.registration.service;

import com.adriel.loginregistrationbackend.registration.dto.RegistrationRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String register(RegistrationRequestDTO registrationRequestDTO) {
        return "works";
    }
}
