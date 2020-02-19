package br.org.ogmorecife.cursomc.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.org.ogmorecife.cursomc.domain.Cliente;
import br.org.ogmorecife.cursomc.repositories.ClienteRepository;
import br.org.ogmorecife.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService{
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
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
