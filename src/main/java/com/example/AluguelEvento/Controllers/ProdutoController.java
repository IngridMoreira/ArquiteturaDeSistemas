package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Produto;
import com.example.AluguelEvento.services.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoService produtoService;

    ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public List<Produto> getAll() {
        return produtoService.allProdutos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Integer id) {
        try {
            Optional<Produto> produtoopt = produtoService.produtoById(id);
            return ResponseEntity.ok(produtoopt.get());
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Produto> adicionar(@RequestBody Produto produto) {
        try {
            produtoService.addProduto(produto);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterarCliente(@PathVariable("id") Integer id,
                                                  @RequestBody Produto produto) {
        try {
            produtoService.atualizarProduto(produto, id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        produtoService.deletarProduto(id);
    }


}
