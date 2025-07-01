package com.orama.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

  @RequestMapping(path = "/login", method = RequestMethod.GET)
  public String index(Model model) {

    return "login";
  }
}
