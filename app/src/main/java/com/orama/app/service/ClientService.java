package com.orama.app.service;

import com.orama.app.dto.clients.ClientRequestDTO;
import com.orama.app.dto.clients.ClientResponseDTO;
import com.orama.app.enums.ClientRolesEnum;
import com.orama.app.model.Client;
import com.orama.app.repository.ClientRepository;
import java.math.BigDecimal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  private final ClientRepository clientRepository;
  private final PasswordEncoder passwordEncoder;

  public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
    this.clientRepository = clientRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public boolean emailExists(String email) {
    return clientRepository.findAll().stream().anyMatch(c -> c.getEmail().equalsIgnoreCase(email));
  }

  public void register(Client client) {
    client.setBalance(BigDecimal.ZERO);
    clientRepository.save(client);
  }

  public ClientResponseDTO create(ClientRequestDTO dto) {
    if (clientRepository.existsByEmail(dto.email())) {
      throw new IllegalArgumentException("Email já está em uso.");
    }

    Client newClient = new Client();
    newClient.setEmail(dto.email());

    newClient.setPassword(passwordEncoder.encode(dto.password()));
    newClient.setRole(ClientRolesEnum.USER);
    newClient.setBalance(BigDecimal.ZERO);

    Client savedClient = clientRepository.save(newClient);

    return new ClientResponseDTO(
        savedClient.getId(), savedClient.getEmail(), savedClient.getRole());
  }
}
