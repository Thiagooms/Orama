package com.orama.app.controller;

import com.orama.app.model.Client;
import com.orama.app.service.ClientService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

  private final ClientService clientService;
  private final BCryptPasswordEncoder passwordEncoder;

  public RegisterController(ClientService clientService, BCryptPasswordEncoder passwordEncoder) {
    this.clientService = clientService;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping("/register")
  public String showRegisterForm() {
    return "register";
  }

  @PostMapping("/register")
  public String processRegister(
      @RequestParam String username,
      @RequestParam String email,
      @RequestParam String password,
      @RequestParam String confirmarSenha,
      Model model) {
    if (!password.equals(confirmarSenha)) {
      model.addAttribute("error", "As senhas não coincidem!");
      return "register";
    }

    if (clientService.emailExists(email)) {
      model.addAttribute("error", "Email já cadastrado!");
      return "register";
    }

    Client client = new Client();
    client.setUsername(username);
    client.setEmail(email);
    client.setPassword(passwordEncoder.encode(password));

    clientService.register(client);
    return "redirect:/login";
  }
}
