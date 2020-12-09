package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DisponibilidadeRepository  extends JpaRepository<Disponibilidade, Integer> {

    List<Disponibilidade> findByNome(String nome);

}
