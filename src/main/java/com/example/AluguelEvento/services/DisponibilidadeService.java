package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.DisponibilidadeRepository;

import com.example.AluguelEvento.model.Disponibilidade;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DisponibilidadeService {
    DisponibilidadeRepository disponibilidadeRepository;

    DisponibilidadeService(DisponibilidadeRepository disponibilidadeRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
    }


    public List<Disponibilidade> allDisponibilidade() {
        return disponibilidadeRepository.findAll();
    }

    public void add(Disponibilidade disponibilidade) {
        Disponibilidade disponibilidadeSalvo = disponibilidadeRepository.save(disponibilidade);
    }

    public List<Disponibilidade> findByName(String nome){
        return disponibilidadeRepository.findByNome(nome);
    }


}
