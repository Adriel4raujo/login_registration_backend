package com.adriel.loginregistrationbackend.registration.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestDTO {
    private final String firstName;
    private final String secondName;
    private final String email;
    private final String password;
}
