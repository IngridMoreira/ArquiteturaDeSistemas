package com.example.AluguelEvento.Controllers;


import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Disponibilidade;
import com.example.AluguelEvento.services.DisponibilidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {
    DisponibilidadeService disponibilidadeService;

    DisponibilidadeController(DisponibilidadeService disponibilidadeService){
        this.disponibilidadeService = disponibilidadeService;
    }

    @GetMapping
    public List<Disponibilidade> getAll() {
        return disponibilidadeService.allDisponibilidade();
    }

    @PostMapping
    public ResponseEntity<Disponibilidade> adicionar(@RequestBody Disponibilidade disponibilidade) {
        try {
            disponibilidadeService.add(disponibilidade);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().build();
        }

    }
}
