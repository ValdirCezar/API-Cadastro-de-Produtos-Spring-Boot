package com.valdir.apistore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.valdir.apistore.domain.Categoria;
import com.valdir.apistore.domain.Produto;
import com.valdir.apistore.repositories.CategoriaRepository;
import com.valdir.apistore.repositories.ProdutoRepository;

@SpringBootApplication
public class ApistoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApistoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Ferramentas");
		Categoria cat3 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Mouse Gamer", 129.90);
		Produto p2 = new Produto(null, "Impressora", 329.90);
		Produto p3 = new Produto(null, "Serra Circular", 350.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		cat3.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat3));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
	}

}
