package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.PedidoQuantidade;
import com.example.AluguelEvento.services.PedidoQuantidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoquantidade")
public class PedidoQuantidadeController {
    PedidoQuantidadeService pedidoQuantidadeService;
    PedidoRepository pedidoRepository;
    ProdutoRepository produtoRepository;

    PedidoQuantidadeController(PedidoQuantidadeService pedidoQuantidadeService){
        this.pedidoQuantidadeService = pedidoQuantidadeService;
    }

    @PostMapping("/pedido/{id_pedido}/produto/{id_produto}")
    public ResponseEntity<PedidoQuantidade> adicionar(@RequestBody PedidoQuantidade pedidoQuantidade,@PathVariable int id_pedido, @PathVariable int id_produto) {
        try {
            pedidoQuantidadeService.addPedidoQuantidade(pedidoQuantidade,id_pedido, id_produto);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/all")
    public List<PedidoQuantidade> getAll() {
        return pedidoQuantidadeService.allPedidoQuantidade();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        pedidoQuantidadeService.removerPedidoQuantidade(id);
    }

}
