package com.example.AluguelEvento.Controllers;

import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);


    @Query("select p from Cliente c join c.pedidos p where c.id = ?1")
    List<Pedido> findPedidos(Integer id);

}
