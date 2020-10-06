package com.example.AluguelEvento;


import java.util.ArrayList;


public class ControleCliente {
    ArrayList<Cliente> clientes = new ArrayList<>();


        Cliente criarCliente(String cpf, String endereco, String nome, String nascimento, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, endereco, nascimento, telefone);
        return cliente;
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
            if(clientes.get(i) != null)
            System.out.println(clientes.get(i).toString());

        }
    }
}
