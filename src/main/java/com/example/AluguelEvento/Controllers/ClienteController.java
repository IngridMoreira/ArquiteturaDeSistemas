package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.ClienteControle;
import com.example.AluguelEvento.services.ClienteService;
import org.springframework.http.HttpStatus;
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
            Optional<Cliente> clienteopt = clienteService.clienteByCpf(cpf);
            return ResponseEntity.ok(clienteopt.get());
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
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        clienteService.deletarCliente(id);
    }

}
