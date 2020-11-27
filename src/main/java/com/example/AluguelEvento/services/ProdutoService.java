package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.ClienteRepository;
import com.example.AluguelEvento.Controllers.ProdutoRepository;
import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }
    Produto p = new Produto();

    public void addProduto(Produto produto){
            p.verificarProduto(produto);
            Produto produtoSalvo = produtoRepository.save(produto);
        }


    public List<Produto> allProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> produtoById(Integer id){
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new RuntimeException("nao existe cliente com este cpf");
        }

        return produto;
    }

    public void atualizarProduto(Produto produto, Integer id){
        Optional<Produto> produtoopt = produtoRepository.findById(id); //pega o cliente

        if(produtoopt.isEmpty()){
            throw new RuntimeException("o cliente nao existe");
        }

        Produto produtoBanco = produtoopt.get();
        p.alterarProduto(produtoBanco,produto); //metodo que altera endereço e/ou telefone
        produtoRepository.save(produtoBanco);
    }

    public void deletarProduto(Integer id){
        produtoRepository.deleteById(id);
    }
}
