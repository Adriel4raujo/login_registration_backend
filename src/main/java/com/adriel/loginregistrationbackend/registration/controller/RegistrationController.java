package com.adriel.loginregistrationbackend.registration.controller;

import com.adriel.loginregistrationbackend.registration.dto.RegistrationRequestDTO;
import com.adriel.loginregistrationbackend.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequestDTO request) {
        return registrationService.register(request);
    }
}
