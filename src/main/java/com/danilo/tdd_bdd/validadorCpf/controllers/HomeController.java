package com.danilo.tdd_bdd.validadorCpf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.danilo.tdd_bdd.validadorCpf.models.Cliente;

@Controller
public class HomeController {

  @GetMapping("/")
  public String index(){
    return "home/index";
  }

  @GetMapping("/valida-cpf")
  public String validaCpf(Cliente cliente, Model model){
    boolean verdade = cliente.validarCPF();
    model.addAttribute("verdade", verdade);
    return "home/cpfValidado";
  }
}
