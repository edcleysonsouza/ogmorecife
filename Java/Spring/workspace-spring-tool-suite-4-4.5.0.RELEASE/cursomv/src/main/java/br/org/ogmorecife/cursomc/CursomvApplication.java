package br.org.ogmorecife.cursomc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class CursomvApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria (null,"Informática");
		Categoria cat2 = new Categoria (null,"Escritório");
		
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
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
