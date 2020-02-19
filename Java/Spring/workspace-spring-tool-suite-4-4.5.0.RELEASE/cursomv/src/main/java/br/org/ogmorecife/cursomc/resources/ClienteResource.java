package br.org.ogmorecife.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.org.ogmorecife.cursomc.domain.Cliente;
import br.org.ogmorecife.cursomc.resources.exception.StandardError;
import br.org.ogmorecife.cursomc.services.ClienteService;
import br.org.ogmorecife.cursomc.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)	
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Cliente obj = service.find(id);			
		return ResponseEntity.ok().body(obj);
	}
	
	
	/*
	
	Implementation with try catch block on the CategoriaResource without use of a ResourceExceptionHandler
	//@RequestMapping(value="/{id}", method = RequestMethod.GET)
	@GetMapping(value="/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		try {
			Categoria obj = service.buscar(id);			
			return ResponseEntity.ok().body(obj);
		}catch (ObjectNotFoundException e){			
			StandardError erro  = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
		}catch (Exception e){
			StandardError erro  = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), System.currentTimeMillis());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);	
		}
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
