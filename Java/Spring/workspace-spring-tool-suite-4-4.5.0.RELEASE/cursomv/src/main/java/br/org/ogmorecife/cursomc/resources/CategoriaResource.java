package br.org.ogmorecife.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.org.ogmorecife.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)	
	public List<Categoria> Listar() {
		
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
		
	}
	
	/*
	
	--- MELHORIAS POSSIVEIS ---
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)	
	public String Listar() {
		return "REST Está funcionando listar";
	}
	
	//Can be also used the @GetMapping instead of @RequestMapping(method = RequestMethod.GET)
	//Which is a shortcut to @RequestMapping(method = RequestMethod.GET)
	@GetMapping (value = "/pesquisar")
	public String Pesquisar() {
		return "REST Está funcionando pesquisar";
	}

	*/
	
	
}
