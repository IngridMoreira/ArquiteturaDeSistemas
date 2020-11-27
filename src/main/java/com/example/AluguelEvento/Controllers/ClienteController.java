package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.ClienteControle;
import com.example.AluguelEvento.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    ClienteControle con = new ClienteControle();
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    public ClienteController( ClienteService clienteService) {

        this.clienteService = clienteService;
    }


    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.allClientes();
    }


    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> getByCpf(@PathVariable("cpf") String cpf) {
        try {
            clienteService.clienteByCpf(cpf);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente) {
        try {
            clienteService.addCliente(cliente);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> alterar(@PathVariable("id") Integer id,
                                           @RequestBody Cliente cliente) {
        try {
            clienteService.atualizarCliente(cliente, id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable("id") Integer id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }

}
