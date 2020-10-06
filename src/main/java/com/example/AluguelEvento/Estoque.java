package com.example.AluguelEvento;

import java.util.ArrayList;

public class Estoque {
     ArrayList<Produto> produtos = new ArrayList();

      Produto criarProduto(String id, String nome, String descricao, int quantidade, double valor){
         Produto prod = new Produto(id,nome,descricao,quantidade,quantidade,valor);
         return prod;
     }
    public void cadastrarProduto(Produto produto){
       produtos.add(produto);
    }

    private int procurarProduto(String id) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public int verificarDisponibilidade(String id){
        return produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
     }

    public void subtrairProdutoQuant(String id,int valor){
         int num = produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
         produtos.get(procurarProduto(id)).setQuantidadeDisponivel(num - valor);
    }

    public void adicionarProdutoQuant(String id,int valor){
        int num = produtos.get(procurarProduto(id)).getQuantidadeDisponivel();
        produtos.get(procurarProduto(id)).setQuantidadeDisponivel(num + valor);
    }


    public void excluirProdutoEstoque(String id){
        produtos.remove(procurarProduto(id));
    }
    public String infoProduto(String id){
        return produtos.get(procurarProduto(id)).toString();
    }
    public void listarProdutos(){
        for (int i = 0; i < produtos.size(); i++) {
            if(produtos.get(i) != null)
                System.out.println(produtos.get(i).toString());

        }
    }
    public void alterarProduto(String id, String descricao, int quantidade, double valor){
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
