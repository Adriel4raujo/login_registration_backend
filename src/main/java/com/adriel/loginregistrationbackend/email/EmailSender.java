package com.adriel.loginregistrationbackend.email;

public interface EmailSender {

    void send(String to, String email);
}
