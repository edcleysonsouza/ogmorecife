package br.org.ogmorecife.cursomc;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import br.org.ogmorecife.cursomc.domain.Categoria;
import br.org.ogmorecife.cursomc.domain.Cidade;
import br.org.ogmorecife.cursomc.domain.Cliente;
import br.org.ogmorecife.cursomc.domain.Endereco;
import br.org.ogmorecife.cursomc.domain.Estado;
import br.org.ogmorecife.cursomc.domain.Pagamento;
import br.org.ogmorecife.cursomc.domain.PagamentoComBoleto;
import br.org.ogmorecife.cursomc.domain.PagamentoComCartao;
import br.org.ogmorecife.cursomc.domain.Pedido;
import br.org.ogmorecife.cursomc.domain.Produto;
import br.org.ogmorecife.cursomc.domain.enums.EstadoPagamento;
import br.org.ogmorecife.cursomc.domain.enums.TipoCliente;
import br.org.ogmorecife.cursomc.repositories.CategoriaRepository;
import br.org.ogmorecife.cursomc.repositories.CidadeRepository;
import br.org.ogmorecife.cursomc.repositories.ClienteRepository;
import br.org.ogmorecife.cursomc.repositories.EnderecoRepository;
import br.org.ogmorecife.cursomc.repositories.EstadoRepository;
import br.org.ogmorecife.cursomc.repositories.PagamentoRepository;
import br.org.ogmorecife.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),cli1,e1);
		Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),cli1,e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);		
		ped2.setPagamento(pagto2);	
			
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
	}

}
