package com.example.AluguelEvento;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    Cliente c = new Cliente();


    @PostMapping
    public void addCliente(@RequestBody Cliente c){
        c.adicionarCliente(c);
        c.listarClientes();
    }

    @PutMapping("/{id}")
    public void alterarCliente(@PathVariable("id") int id, @RequestBody Cliente c){

    }

    @DeleteMapping("/{id}")
    public void removeCliente(@PathVariable("id") int id){

    }




}
