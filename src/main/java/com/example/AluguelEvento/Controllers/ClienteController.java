package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.clienteControle;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    clienteControle con = new clienteControle();


    @PostMapping
    public void criarCliente(@RequestBody Cliente c){
        con.adicionarCliente(c);
        con.listarClientes();
    }

    @PatchMapping("/{id}")
    public void alterarCliente(@PathVariable("id") int id, @RequestBody Cliente c){


    }

    @DeleteMapping("/{id}")
    public void removeCliente(@PathVariable("id") int id){

    }

    @GetMapping
    public void listarClientes(@RequestBody Cliente c){
        con.listarClientes();
    }




}
