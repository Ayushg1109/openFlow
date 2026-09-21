package com.openflow.auth;

public record LoginRequest(
        String email,
        String password
) {
}