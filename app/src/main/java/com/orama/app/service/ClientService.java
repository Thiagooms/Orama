package com.orama.app.service;

import com.orama.app.model.Client;
import com.orama.app.repository.ClientRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired private ClientRepository clientRepository;

  public boolean emailExists(String email) {
    return clientRepository.findAll().stream().anyMatch(c -> c.getEmail().equalsIgnoreCase(email));
  }

  public void register(Client client) {
    client.setBalance(BigDecimal.ZERO);
    clientRepository.save(client);
  }
}
