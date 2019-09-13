package com.ptavares.estudoGlores1.estudoGlores1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;
import com.ptavares.estudoGlores1.estudoGlores1.model.Produto;
import com.ptavares.estudoGlores1.estudoGlores1.repository.FabricanteRepository;
import com.ptavares.estudoGlores1.estudoGlores1.repository.ProdutoRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		fabricanteRepository.deleteAll();
		produtoRepository.deleteAll();
		
		Fabricante fab1 = new Fabricante(null, "Fabricante 1", "São Paulo", "SP", "Av. Santo Amaro", "fabricante1@gmail.com", "999999999");
		Fabricante fab2 = new Fabricante(null, "Vivo", "Curitiba", "PR", "Rua do Frio", "vivo@gmail.com", "888888888");
		Fabricante fab3 = new Fabricante(null, "Claro", "Florianópolis", "SC", "Rua Praia da Joaquina ", "claro@gmail.com", "777777777");
		Fabricante fab4 = new Fabricante(null, "Oi", "Belo Horizonte", "MG", "Av Pé de Moleque", "oi@gmail.com", "666666666");
		Fabricante fab5 = new Fabricante(null, "Tim", "Campinas", "SP", "Rua Shopping Iguatemi", "tim@gmail.com", "555555555");
		
		fabricanteRepository.saveAll(Arrays.asList(fab1, fab2, fab3, fab4, fab5));
		
		Produto prod1 = new Produto(null, "Produto 1", "É o melhor produto 1 do mercado");
		Produto prod2 = new Produto(null, "Produto 2", "É o melhor produto 2 do mercado");
		Produto prod3 = new Produto(null, "Produto 3", "É o melhor produto 3 do mercado");
		Produto prod4 = new Produto(null, "Produto 4", "É o melhor produto 4 do mercado");
		
		produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
		
		fab2.getProdutos().addAll(Arrays.asList(prod1, prod2));
		fab5.getProdutos().addAll(Arrays.asList(prod3, prod4));
		
		fabricanteRepository.saveAll(Arrays.asList(fab2, fab5));
		
	}
}
