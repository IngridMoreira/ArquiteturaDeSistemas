package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.ClienteRepository;
import com.example.AluguelEvento.Controllers.PedidoQuantidadeRepository;
import com.example.AluguelEvento.Controllers.PedidoRepository;

import com.example.AluguelEvento.Controllers.ProdutoRepository;
import com.example.AluguelEvento.model.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    PedidoRepository pedidoRepository;
    ClienteRepository clienteRepository;
    ProdutoRepository produtoRepository;
    ProdutoService produtoService;
    DisponibilidadeService disponibilidadeService;
    PedidoQuantidadeRepository pedidoQuantidadeRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProdutoRepository produtoRepository,
                         ProdutoService produtoService,
                         DisponibilidadeService disponibilidadeService, PedidoQuantidadeRepository pedidoQuantidadeRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
        this.disponibilidadeService = disponibilidadeService;
        this.pedidoQuantidadeRepository = pedidoQuantidadeRepository;
    }

    public Pedido getPedido(int idPedido) {
        Optional<Pedido> p = pedidoRepository.findById(idPedido);
        return p.get();
    }


    public List<Pedido> allPedidos() {

        return pedidoRepository.findAll();
    }

    public List<PedidoQuantidade> getPedidoQuantidade(int id){
        return pedidoRepository.findPedidosQuantidade(id);
    }

    public void addPedido(Pedido pedido, int idCliente) {
        int cont = 0;
        Optional<Cliente> c = clienteRepository.findById(idCliente);


        if (c.isEmpty()) {
            throw new RuntimeException("o cliente nao existe");
        } else {
            Cliente cliente = c.get();


            pedido.setData_compra(Calendar.getInstance().getTime());
            pedido.setCliente(cliente);
            pedido.setValor(0);
            Pedido pedidoSalvo = pedidoRepository.save(pedido);


        }
    }


    public void deletarPedido(int id) {
        pedidoRepository.deleteById(id);
    }


}
