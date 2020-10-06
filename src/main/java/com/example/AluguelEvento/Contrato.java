package com.example.AluguelEvento;

import java.util.Date;

public class Contrato {
    private Date diaEvento;
    private Date dataEntrega;
    private Date diaDevolucao;
    private double valor;
    private String status;
    private String tipoEntrega;
    private String endereco;
    private Pedido pedido;



    public Contrato(Date diaEvento, Date dataEntrega, Date diaDevolucao, double valor, String status, String tipoEntrega, String endereco, Pedido pedido) {
        this.diaEvento = diaEvento;
        this.dataEntrega = dataEntrega;
        this.diaDevolucao = diaDevolucao;
        this.valor = valor;
        this.status = status;
        this.tipoEntrega = tipoEntrega;
        this.endereco = endereco;
        this.pedido = pedido;
    }

    public Date getDiaEvento() {
        return diaEvento;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public Date getDiaDevolucao() {
        return diaDevolucao;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public Pedido getPedido() {
        return pedido;
    }
}
