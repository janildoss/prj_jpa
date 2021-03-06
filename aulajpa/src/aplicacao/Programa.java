package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();		
		
		int opc = 3;
		
		switch (opc) {
		
		case 1:
			//inclusao
			Pessoa p1 = new Pessoa(null,"Carlos da Silva","carlos@gmail.com");
			Pessoa p2 = new Pessoa(null,"Maria das Dores","carlos@gmail.com");
			Pessoa p3 = new Pessoa(null,"Nilma Cerqueira Santos","nilmacs@gmail.com");			
			
			em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.getTransaction().commit();
		
			System.out.println("Inclusao com sucesso");		
			break;			
		
		case 2:
			//consulta
			Pessoa p = em.find(Pessoa.class,4);			
		
		    //imprime na tela os dados trazido do banco.
		    System.out.println(p.getNome()+'-'+p.getEmail());		
		    break;		    
		
		case 3:
			//Remover
			Pessoa ex = em.find(Pessoa.class,5);
			em.getTransaction().begin();
			em.remove(ex);
			em.getTransaction().commit();
		
		    System.out.println("Registro removido!");		
		    break;
					
		default:
		
		System.out.println("Nehuma op��o selecionada!");
		
		}		
		
		em.close();
		emf.close();

	}

}
