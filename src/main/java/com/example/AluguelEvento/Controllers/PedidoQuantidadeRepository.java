package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.PedidoQuantidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoQuantidadeRepository extends JpaRepository<PedidoQuantidade, Integer> {


}
