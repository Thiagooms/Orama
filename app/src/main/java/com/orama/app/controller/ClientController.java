package com.orama.app.controller;

import com.orama.app.dto.clients.ClientRequestDTO;
import com.orama.app.dto.clients.ClientResponseDTO;
import com.orama.app.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO dto) {
    ClientResponseDTO response = clientService.create(dto);
    return ResponseEntity.ok(response);
  }
}
