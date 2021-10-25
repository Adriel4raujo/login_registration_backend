package com.adriel.loginregistrationbackend.security.utils;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        //TODO: add an email validation with regex
        return true;
    }
}
