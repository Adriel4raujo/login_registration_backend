package com.adriel.loginregistrationbackend.registration.token.service;

import com.adriel.loginregistrationbackend.appuser.service.AppUserService;
import com.adriel.loginregistrationbackend.registration.token.model.ConfirmationToken;
import com.adriel.loginregistrationbackend.registration.token.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
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

        confirmationToken.setConfirmedAt(LocalDateTime.now());
        confirmationTokenRepository.save(confirmationToken);

        return confirmationToken;
    }
}
