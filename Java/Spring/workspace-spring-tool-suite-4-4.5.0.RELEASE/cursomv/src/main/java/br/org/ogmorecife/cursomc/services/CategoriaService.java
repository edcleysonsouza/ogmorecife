package br.org.ogmorecife.cursomc.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.repositories.CategoriaRepository;
import br.org.ogmorecife.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService{
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	//Another way of throw the exception
	/*public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repo.findById(id);			
		
		if (categoria.isPresent())
			return categoria.get();
		else		
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());		
		
	}*/

}
