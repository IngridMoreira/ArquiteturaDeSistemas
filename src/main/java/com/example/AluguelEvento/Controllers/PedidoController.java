package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @PostMapping
    public void addPedido(@RequestBody Cliente c){

    }

    @PutMapping("/{id}")
    public void updatePedido(@PathVariable("id") int id, @RequestBody Cliente c){

    }

    @DeleteMapping("/{id}")
    public void delPedido(@PathVariable("id") int id){

    }
}
