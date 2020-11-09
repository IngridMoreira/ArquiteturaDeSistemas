package com.example.AluguelEvento.model;




public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String nascimento;
    private String telefone;
    private long id;



    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", nascimento=" + nascimento +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public Cliente(String nome, String cpf, String endereco, String nascimento, String telefone, long id) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.id = id;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getTelefone() {
        return telefone;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
