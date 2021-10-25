package com.adriel.loginregistrationbackend.registration.token.service;

import com.adriel.loginregistrationbackend.appuser.service.AppUserService;
import com.adriel.loginregistrationbackend.registration.token.model.ConfirmationToken;
import com.adriel.loginregistrationbackend.registration.token.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public ConfirmationToken confirmToken(String token) {
        Optional<ConfirmationToken> confirmationTokenOpt = confirmationTokenRepository.findByToken(token);

        boolean tokenExists = confirmationTokenOpt.isPresent();
        if (!tokenExists)
            throw new IllegalStateException("Token does not exists.");

        ConfirmationToken confirmationToken = confirmationTokenOpt.get();

        log.info("Expires at: " + confirmationToken.getExpiresAt());
        log.info("Now: " + LocalDateTime.now());
        boolean isTokenExpired = confirmationToken.getExpiresAt().isAfter(LocalDateTime.now());

        if (isTokenExpired)
            throw new IllegalStateException("Token expired.");

        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(confirmationToken);

        return confirmationToken;
    }
}
