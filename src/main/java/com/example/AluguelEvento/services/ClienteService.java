package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.ClienteRepository;
import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.ClienteControle;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    ClienteControle con = new ClienteControle();

    ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public void atualizarCliente(Cliente cliente, Integer id){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id); //pega o cliente

        if(clienteOpt.isEmpty()){
            throw new RuntimeException("o cliente nao existe");
        }

        Cliente clienteBanco = clienteOpt.get();
        con.alterarCliente(clienteBanco,cliente); //metodo que altera endereço e/ou telefone
        clienteRepository.save(clienteBanco);
    }

    @Transactional
    public void clienteByCpf(String cpf){
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        if (cliente.isEmpty()) {
            throw new RuntimeException("nao existe cliente com este cpf");
        }
    }

    public List<Cliente> allClientes(){
        return clienteRepository.findAll();
    }

    @Transactional
    public void addCliente(Cliente cliente){
        con.verificarCliente(cliente);
        Cliente clienteSalvo = clienteRepository.save(cliente);
    }

    @Transactional
    public void deletarCliente(Integer id){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        if(clienteOpt.isEmpty()){
            throw new RuntimeException("o cliente nao existe");
        }
        clienteRepository.deleteById(id);
    }
}
