package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null,"Edcleysond de Souza","edcleyson@oi.com.br");
		Pessoa p2 = new Pessoa(null,"Gerciliana","gerciliana@oi.com.br");
		Pessoa p3 = new Pessoa(null,"Maria de Souza","maria@oi.com.br");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Inserir na base
		/*em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);*/
		
		//Recuperar da base
		/*Pessoa p = em.find(Pessoa.class,3);
		System.out.println(p);*/
		
		//Excluir da base
		Pessoa p = em.find(Pessoa.class,2);
		if (p != null) {			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Pessoa Exclu�da!");
		
		}else {
			System.out.println("Pessoa n�o encontrada");
		}
		
		em.close();
		emf.close();	

	}

}
