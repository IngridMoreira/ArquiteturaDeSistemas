package com.example.AluguelEvento;

import java.util.ArrayList;

public class Produto {
    private long id;
    private String nome;
    private String descricao;
    private int quantidade;
    private int quantidadeDisponivel;
    private double valor;
    ArrayList<Produto> produtos = new ArrayList();

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", quantidadeDisponivel=" + quantidadeDisponivel +
                ", valor=" + valor +
                '}';
    }

    public Produto(long id, String nome, String descricao, int quantidade, int quantidadeDisponivel, double valor) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.valor = valor;
    }

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
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

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void cadastrarProduto(Produto produto){

        produtos.add(produto);
    }

    private int procurarProduto(long id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public int verificarDisponibilidade(long id){
        return produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
    }

    public void subtrairProdutoQuant(long id,int valor){
        int num = produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
        produtos.get(procurarProduto(id)).setQuantidadeDisponivel(num - valor);
    }

    public void adicionarProdutoQuant(long id,int valor){
        int num = produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
        produtos.get(procurarProduto(id)).setQuantidadeDisponivel(num + valor);
    }


    public void excluirProdutoEstoque(long id){

        produtos.remove(procurarProduto(id));
    }

    public String infoProduto(long id){

        return produtos.get(procurarProduto(id)).toString();
    }

    public void listarProdutos(){
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i) != null)
                System.out.println(produtos.get(i).toString());

        }
    }

    public void alterarProduto(long id, String descricao, int quantidade, double valor){
        if (!descricao.isEmpty()) {
            produtos.get(procurarProduto(id)).setDescricao(descricao);
        }

        if (quantidade != -1) {
            produtos.get(procurarProduto(id)).setQuantidade(quantidade);
        }

        if (valor != -1) {
            produtos.get(procurarProduto(id)).setValor(valor);
        }
    }
}
