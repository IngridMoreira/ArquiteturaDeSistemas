package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Pedido;
import com.example.AluguelEvento.model.PedidoQuantidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("select pq from Pedido p join p.pedidoQuantidade pq where p.id = ?1")
    List<PedidoQuantidade> findPedidosQuantidade(Integer id);

}
