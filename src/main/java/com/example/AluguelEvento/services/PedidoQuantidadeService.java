package com.example.AluguelEvento.services;

import com.example.AluguelEvento.Controllers.PedidoQuantidadeRepository;
import com.example.AluguelEvento.Controllers.PedidoRepository;
import com.example.AluguelEvento.Controllers.ProdutoRepository;
import com.example.AluguelEvento.model.*;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoQuantidadeService {
    PedidoQuantidadeRepository pedidoQuantidadeRepository;
    ProdutoRepository produtoRepository;
    PedidoRepository pedidoRepository;
    DisponibilidadeService disponibilidadeService;

    public PedidoQuantidadeService(PedidoQuantidadeRepository pedidoQuantidadeRepository, ProdutoRepository produtoRepository, PedidoRepository pedidoRepository, DisponibilidadeService disponibilidadeService) {
        this.pedidoQuantidadeRepository = pedidoQuantidadeRepository;
        this.produtoRepository = produtoRepository;
        this.pedidoRepository = pedidoRepository;
        this.disponibilidadeService = disponibilidadeService;
    }



    public void addPedidoQuantidade(PedidoQuantidade pedidoQuantidade, int id_pedido, int id_produto) {
        Optional<Pedido> ped = this.pedidoRepository.findById(id_pedido);
        Optional<Produto> prod = this.produtoRepository.findById(id_produto);
        Pedido pedido = ped.get();
        Produto produto = prod.get();
        if(alterarDisponibilidade(pedido, produto, pedidoQuantidade.getQuantidade())) {
            pedidoQuantidade.setPedido(pedido);
            pedidoQuantidade.setProduto(produto);
            pedido.setValor(pedido.getValor() + pedidoQuantidade.getQuantidade() * produto.getValor());
            this.pedidoRepository.save(pedido);
            PedidoQuantidade pedidoQuantidadeSalvo = pedidoQuantidadeRepository.save(pedidoQuantidade);
        }

    }


    public boolean alterarDisponibilidade(Pedido pedido, Produto produto, int qtd) {
        int cont = 0;
        List<Disponibilidade> listaD = disponibilidadeService.findByName(produto.getNome());
        for (int i = 0; i < listaD.size(); i++) {
            if (listaD.get(i).getData_devolucao().after(Calendar.getInstance().getTime()))
                cont += listaD.get(i).getQuantidade();
        }

        if((produto.getQuantidade() - cont) >= qtd){
            Disponibilidade disponibilidade = new Disponibilidade(pedido.getData_devolucao(), produto.getNome(), qtd);
            disponibilidadeService.add(disponibilidade);
            return true;
        }
        return false;
    }

    public List<PedidoQuantidade> allPedidoQuantidade() {

        return pedidoQuantidadeRepository.findAll();
    }

    public void removerPedidoQuantidade(int id){
        Optional<PedidoQuantidade> pedOpt = this.pedidoQuantidadeRepository.findById(id);
        PedidoQuantidade pedidoQuantidade = pedOpt.get();
        Pedido pedido = pedidoQuantidade.getPedido();
        Produto produto = pedidoQuantidade.getProduto();
        pedido.setValor(pedido.getValor() - pedidoQuantidade.getQuantidade()*produto.getValor());

        this.pedidoRepository.save(pedido);
        this.pedidoQuantidadeRepository.delete(pedidoQuantidade);
    }
}
