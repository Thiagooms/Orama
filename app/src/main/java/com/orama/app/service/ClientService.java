package com.orama.app.service;

import com.orama.app.model.Client;
import com.orama.app.repository.ClientRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

  @Autowired private ClientRepository clientRepository;

  public Client save(Client client) {
    String hashed = BCrypt.hashpw(client.getPassword(), BCrypt.gensalt());
    client.setPassword(hashed);
    return clientRepository.save(client);
  }
}
