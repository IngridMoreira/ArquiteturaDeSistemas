package com.example.AluguelEvento.model;

import java.util.ArrayList;

public class estoque {
    ArrayList<Produto> produtos = new ArrayList();

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

    public void cadastrarProduto(Produto produto){

        produtos.add(produto);
    }
}
