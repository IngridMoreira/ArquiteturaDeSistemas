package com.example.AluguelEvento.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @GetMapping
    public void listarContratos(){

    }

    @PostMapping
    public void criarContrato(){

    }

}
