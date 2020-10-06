package com.example.AluguelEvento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluguelEventoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelEventoApplication.class, args);

		Estoque e = new Estoque();

		e.cadastrarProduto(e.criarProduto("1","cadeira","objeto para sentar",30,50.0));
		e.cadastrarProduto(e.criarProduto("2","sofa","objeto para sentar",20,150.0));

		e.listarProdutos();
	}

}
