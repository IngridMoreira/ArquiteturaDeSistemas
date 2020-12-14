package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Pedido;
import com.example.AluguelEvento.model.PedidoQuantidade;
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



    @PostMapping("/clientes/{idCliente}")
    public ResponseEntity<Pedido> addPedido(@PathVariable("idCliente") int idCliente, @RequestBody Pedido pedido) {
        try {
            pedidoService.addPedido(pedido, idCliente);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }


    @GetMapping
    public List<Pedido> allPedidos() {
        return pedidoService.allPedidos();
    }

    @GetMapping("/{id}")
    public Pedido getPedido(@PathVariable("id") int id){
        return pedidoService.getPedido(id);
    }

    @GetMapping("/produtos/{id}")
    public List<PedidoQuantidade> getPedidoQuantidade(@PathVariable("id") int id){
        return pedidoService.getPedidoQuantidade(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delPedido(@PathVariable("id") int id) {
        pedidoService.deletarPedido(id);
    }
}
