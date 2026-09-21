package com.openflow.auth;

import com.openflow.user.User;
import com.openflow.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(RegisterRequest request) {

        String email = request.email();

        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException(
                    "Email already registered"
            );
        }

        String passwordHash =
                passwordEncoder.encode(request.password());

        User user = new User(
                email,
                passwordHash
        );

        userRepository.save(user);
    }
}