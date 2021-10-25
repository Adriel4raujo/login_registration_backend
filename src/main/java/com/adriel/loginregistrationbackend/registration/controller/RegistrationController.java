package com.adriel.loginregistrationbackend.registration.controller;

import com.adriel.loginregistrationbackend.registration.dto.RegistrationRequestDTO;
import com.adriel.loginregistrationbackend.registration.service.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping("/test")
    public String register(@RequestBody RegistrationRequestDTO request) {
        log.info("Registring " + request);
        return registrationService.register(request);
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam("token") String token) {
        log.info("Confirming");
        return registrationService.confirmToken(token);
    }
}
