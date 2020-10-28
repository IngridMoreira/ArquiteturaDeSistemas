package com.example.AluguelEvento;


import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String nascimento;
    private String telefone;
    private long id;
    ArrayList<Cliente> clientes = new ArrayList<>();


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

    public void adicionarCliente(Cliente cliente) {

        clientes.add(cliente);
    }

    private int procurarCliente(String cpf) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

    public void excluirCliente(String cpf) {

        clientes.remove(procurarCliente(cpf));
    }

    public String infoCliente(String cpf) {

        return clientes.get(procurarCliente(cpf)).toString();
    }

    public void alterarCliente(String cpf, String telefone, String endereco) {
        if (!telefone.isEmpty()) {
            clientes.get(procurarCliente(cpf)).setTelefone(telefone);
        }
        if (!endereco.isEmpty()) {
            clientes.get(procurarCliente(cpf)).setEndereco(endereco);
        }
    }

    public void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i) != null)
                System.out.println(clientes.get(i).toString());

        }
    }
}
