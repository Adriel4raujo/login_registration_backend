package com.adriel.loginregistrationbackend.registration.controller;

import com.adriel.loginregistrationbackend.registration.dto.RegistrationRequestDTO;
import com.adriel.loginregistrationbackend.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/test")
    public String register(@RequestBody RegistrationRequestDTO request) {
        System.out.println("TESTE");
        log.info("Registring " + request);
        return registrationService.register(request);
    }
}
