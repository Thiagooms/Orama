package com.orama.app.dto.auth;

import com.orama.app.model.Client;
import com.orama.app.repository.ClientRepository;
import com.orama.app.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(ClientRepository clientRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ClientResponseLoginDTO login(ClientRequestLoginDTO dto) {
        Client client = clientRepository.findByEmail(dto.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(dto.password(), client.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        String token = jwtService.generateToken(client);

        Instant expiresAt = jwtService.generateExpirationDate();

        return new ClientResponseLoginDTO(token, client.getRole().name(), expiresAt);
    }
}
