package com.adriel.loginregistrationbackend.registration.token.repository;

import com.adriel.loginregistrationbackend.registration.token.model.ConfirmationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(String token);
}
