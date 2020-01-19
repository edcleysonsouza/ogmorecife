package br.org.ogmorecife.cursomc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.domain.Produto;
import br.org.ogmorecife.cursomc.repositories.CategoriaRepository;
import br.org.ogmorecife.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomvApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		Another way to implements the inserts into to the database.
		Just for adaptations in legacy applications if necessary.
		1)  
		List<Categoria> categorias = new ArrayList<>();
		categorias.add(cat1);
		categorias.add(cat2);
		categoriaRepository.saveAll(categorias);
		2)
		List<Categoria> lista = Arrays.asList(cat1, cat2);		
		categoriaRepository.saveAll(lista);*/
		
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria (null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.setProdutos(Arrays.asList(p1,p2, p3));
		cat2.setProdutos(Arrays.asList(p2));
		
		p1.setCategorias(Arrays.asList(cat1));
		p2.setCategorias(Arrays.asList(cat1,cat2));
		p3.setCategorias(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));		
		
	}

}
