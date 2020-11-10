package com.example.AluguelEvento.model;

import java.util.ArrayList;

public class clienteControle {
    ArrayList<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente) {

        clientes.add(cliente);
    }

    private int procurarCliente(long id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void excluirCliente(long id) {

        clientes.remove(procurarCliente(id));
    }

    public String infoCliente(long id) {

        return clientes.get(procurarCliente(id)).toString();
    }

    public void alterarCliente(long id, String telefone, String endereco) {
        if (!telefone.isEmpty()) {
            clientes.get(procurarCliente(id)).setTelefone(telefone);
        }
        if (!endereco.isEmpty()) {
            clientes.get(procurarCliente(id)).setEndereco(endereco);
        }
    }

    public void listarClientes() {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i) != null)
                System.out.println(clientes.get(i).toString());

        }
    }
}
