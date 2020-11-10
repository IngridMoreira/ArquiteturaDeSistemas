package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class produtoController {

    @PostMapping
    public void criarProduto(@RequestBody Cliente c){

    }

    @GetMapping
    public void listarProdutos(){

    }

    @PutMapping("/{id}")
    public void alterarProduto(@PathVariable("id") int id, @RequestBody Cliente c){

    }

    @PatchMapping("/{id}")
    public void alterarDadosProduto(@PathVariable("id") int id, @RequestBody Cliente c){

    }

    @DeleteMapping("/{id}")
    public void removeProduto(@PathVariable("id") int id){

    }
}
