package com.openflow.auth;

public record RegisterRequest(
        String email,
        String password
) {
}