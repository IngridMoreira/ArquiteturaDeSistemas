package com.example.AluguelEvento;

public class PedidoProduto {
    private Produto produto;
    private String idPedido;
    private int Quantidade;

    public PedidoProduto(Produto produto, String idPedido, int quantidade) {
        this.produto = produto;
        this.idPedido = idPedido;
        Quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public int getQuantidade() {
        return Quantidade;
    }
}
