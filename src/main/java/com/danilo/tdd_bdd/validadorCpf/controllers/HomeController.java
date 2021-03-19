package com.danilo.tdd_bdd.validadorCpf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String index(){
    return "home/index";
  }

  @GetMapping("/valida-cpf")
  public String validaCpf(){
    return "home/cpfValidado";
  }
}
