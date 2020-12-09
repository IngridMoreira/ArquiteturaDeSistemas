package com.example.AluguelEvento.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "disponibilidade")
@Entity
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data_devolucao;

    private String nome;
    private int quantidade;

    public Integer getId() {
        return id;
    }



    public Disponibilidade(Date data_devolucao, String nome, int quantidade) {
        this.data_devolucao = data_devolucao;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Disponibilidade() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
