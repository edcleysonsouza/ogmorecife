package br.org.ogmorecife.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	//@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
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
