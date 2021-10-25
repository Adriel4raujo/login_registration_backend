package com.adriel.loginregistrationbackend.registration.service;

import com.adriel.loginregistrationbackend.appuser.enums.AppUserRoleEnum;
import com.adriel.loginregistrationbackend.appuser.model.AppUser;
import com.adriel.loginregistrationbackend.appuser.service.AppUserService;
import com.adriel.loginregistrationbackend.registration.dto.RegistrationRequestDTO;
import com.adriel.loginregistrationbackend.registration.token.model.ConfirmationToken;
import com.adriel.loginregistrationbackend.registration.token.service.ConfirmationTokenService;
import com.adriel.loginregistrationbackend.security.utils.EmailValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;

    public String register(RegistrationRequestDTO registrationRequestDTO) {
        boolean isEmailValid = emailValidator.test(registrationRequestDTO.getEmail());

        if (!isEmailValid)
            throw new IllegalStateException("Email not valid");

        log.info("Signing Up user");
        return appUserService.signUpUser(
                new AppUser(
                        registrationRequestDTO.getFirstName(),
                        registrationRequestDTO.getSecondName(),
                        registrationRequestDTO.getEmail(),
                        registrationRequestDTO.getPassword(),
                        AppUserRoleEnum.USER
                )
        );
    }

    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.confirmToken(token);

        appUserService.enablingUser(confirmationToken.getAppUser());

        return "Token confirmed!";
    }
}
