package br.org.ogmorecife.cursomc;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.domain.Cidade;
import br.org.ogmorecife.cursomc.domain.Cliente;
import br.org.ogmorecife.cursomc.domain.Endereco;
import br.org.ogmorecife.cursomc.domain.Estado;
import br.org.ogmorecife.cursomc.domain.Produto;
import br.org.ogmorecife.cursomc.domain.enums.TipoCliente;
import br.org.ogmorecife.cursomc.repositories.CategoriaRepository;
import br.org.ogmorecife.cursomc.repositories.CidadeRepository;
import br.org.ogmorecife.cursomc.repositories.ClienteRepository;
import br.org.ogmorecife.cursomc.repositories.EnderecoRepository;
import br.org.ogmorecife.cursomc.repositories.EstadoRepository;
import br.org.ogmorecife.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomvApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
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
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.setCidades(Arrays.asList(c1));
		est2.setCidades(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		
		//Set<String> tl = new HashSet<>();
		//tl.addAll(Arrays.asList("12345678","32165487"));
		cli1.getTelefone().addAll(Arrays.asList("12345678","32165487"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apt 203","Jardim","38220834",cli1,c1);
		Endereco e2 = new Endereco(null,"Av Matos","105","Sala 800","Centro","38777012",cli1,c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}
