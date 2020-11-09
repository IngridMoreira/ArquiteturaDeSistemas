package com.example.AluguelEvento.model;

import com.example.AluguelEvento.PedidoProduto;

public class Pedido {
    Pedido[] pedidos = new Pedido[1000];
    private long id;
    private Cliente cliente;

    public void statusPedido(String id){}
    public void gerarOrcamento(PedidoProduto[] pedidos){}

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
