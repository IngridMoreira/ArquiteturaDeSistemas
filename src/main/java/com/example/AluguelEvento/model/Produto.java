package com.example.AluguelEvento.model;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "produto")
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private int quantidade;
    private double valor;




    public Produto(int id, String nome, String descricao, int quantidade, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Produto() {
    }
    public void verificarProduto(Produto produto){
        if(produto.getNome() == ""){
            throw new RuntimeException("o produto precisa de um nome");
        }

        if(produto.getDescricao() == ""){
            throw new RuntimeException("o cliente precisa de descricao");
        }

    }

    public void alterarProduto(Produto original,Produto alterado) {

        if(original.getQuantidade() != alterado.getQuantidade()){
            original.setQuantidade(alterado.getQuantidade());
        }

        if(original.getValor() != alterado.getValor()){
            original.setValor(alterado.getValor());
        }

        if(original.getDescricao() != alterado.getDescricao()){
            original.setDescricao(alterado.getDescricao());
        }

        if(original.getNome() != alterado.getNome()){
            original.setNome(alterado.getNome());
        }
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public double getValor() {
        return valor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }




}
