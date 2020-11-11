package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Contrato;
import com.example.AluguelEvento.model.contratoControle;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contratos")
public class ContratoController {
    contratoControle con = new contratoControle();

    @GetMapping
    public void listarContratos(){

    }

    @PostMapping
    public void criarContrato(@RequestBody Contrato c){

        con.criarContrato(c);
    }

    @DeleteMapping("/{id}")
    public void excluirContrato(@RequestBody Contrato c,@PathVariable("id") int id){

    }

}
