package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Pedido;
import com.example.AluguelEvento.services.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private PedidoService pedidoService;

    PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/clientes/{idCliente}/produtos/{idProduto}")
    public ResponseEntity<Pedido> addPedido(@PathVariable("idCliente") int idCliente, @PathVariable("idProduto") int idProduto, @RequestBody Pedido pedido) {
        try {
            pedidoService.addPedido(pedido, idCliente, idProduto);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping
    public List<Pedido> allPedidos() {
        return pedidoService.allPedidos();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delPedido(@PathVariable("id") int id) {
        pedidoService.deletarPedido(id);
    }
}
