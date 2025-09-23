package com.orama.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

  @PreAuthorize("hasRole('USER')")
  @GetMapping
  public String getClient() {
    return "Admin";
  }
}
