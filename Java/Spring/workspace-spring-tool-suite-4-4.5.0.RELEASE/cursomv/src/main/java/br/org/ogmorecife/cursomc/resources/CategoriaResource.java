package br.org.ogmorecife.cursomc.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)	
	public String Listar() {
		return "REST Está funcionando";
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
