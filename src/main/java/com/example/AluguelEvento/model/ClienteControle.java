package com.example.AluguelEvento.model;



public class ClienteControle {

    public void alterarCliente(Cliente original,Cliente alterado) {


        if(original.getEndereco() != alterado.getEndereco()){
           original.setEndereco(alterado.getEndereco());
       }

        if(original.getTelefone() != alterado.getTelefone()){
            original.setTelefone(alterado.getTelefone());
        }
    }

    public void verificarCliente(Cliente cliente){
        if(cliente.getCpf() == null){
            throw new RuntimeException("o cliente precisa de cpf");
        }

        if(cliente.getTelefone() == null){
            throw new RuntimeException("o cliente precisa de telefone");
        }

        if(cliente.getEndereco() == null){
            throw new RuntimeException("o cliente precisa de endereco");
        }

        if(cliente.getNome() == null){
            throw new RuntimeException("o cliente precisa de nome");
        }

        if(cliente.getNascimento() == null){
            throw new RuntimeException("o cliente precisa de data de nascimento");
        }
    }


}
