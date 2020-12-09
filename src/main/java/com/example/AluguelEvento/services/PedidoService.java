package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.ClienteRepository;
import com.example.AluguelEvento.Controllers.PedidoRepository;

import com.example.AluguelEvento.Controllers.ProdutoRepository;
import com.example.AluguelEvento.model.Cliente;
import com.example.AluguelEvento.model.Disponibilidade;
import com.example.AluguelEvento.model.Pedido;
import com.example.AluguelEvento.model.Produto;
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

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProdutoRepository produtoRepository,
                         ProdutoService produtoService,
                         DisponibilidadeService disponibilidadeService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
        this.disponibilidadeService = disponibilidadeService;
    }


    public List<Pedido> allPedidos() {
        return pedidoRepository.findAll();
    }

    public void addPedido(Pedido pedido, int idCliente, int idProduto) {
        int cont = 0;
        Optional<Cliente> c = clienteRepository.findById(idCliente);
        Optional<Produto> p = produtoRepository.findById(idProduto);

        if(c.isEmpty() || p.isEmpty()){
            throw new RuntimeException("o cliente ou produto nao existe");
        }else {
            Cliente cliente = c.get();
            Produto produto = p.get();
            List<Disponibilidade> listaD = disponibilidadeService.findByName(produto.getNome());


            for (int i = 0; i < listaD.size(); i++) {
                if (listaD.get(i).getData_devolucao().after(Calendar.getInstance().getTime()))
                    cont += listaD.get(i).getQuantidade();
            }

            if ((produto.getQuantidade() - cont) >= pedido.getQuantidade()) {
                pedido.setData_compra(Calendar.getInstance().getTime());
                pedido.setCliente(cliente);
                pedido.setProduto(produto);
                pedido.setValor(pedido.getQuantidade() * produto.getValor());
                Pedido pedidoSalvo = pedidoRepository.save(pedido);
                Disponibilidade disponibilidade = new Disponibilidade(pedido.getData_devolucao(), produto.getNome(), pedido.getQuantidade());
                disponibilidadeService.add(disponibilidade);
            }


        }
    }


    public void deletarPedido(int id) {
        pedidoRepository.deleteById(id);
    }


}
