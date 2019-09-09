package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Conta;

public class ContaImpl {
	
		EntityManager em;
		EntityManagerFactory emf;
		
		public ContaImpl() {
			
			emf = Persistence.createEntityManagerFactory("testePU");
			em = emf.createEntityManager();
			
		}
		
		public void salvar(Conta conta) {
			
			em.getTransaction().begin();
			em.persist(conta);
			em.getTransaction().commit();
			emf.close();
			
		}
		
		public void remover(Conta conta) {
			
			em.getTransaction().begin();
			em.remove(conta);
			em.getTransaction().commit();
			emf.close();
			
		}
		public void atualizar(Conta conta) {
			
			em.getTransaction().begin();
			em.merge(conta);
			em.getTransaction().commit();
			emf.close();
			
			
		}
		
		@SuppressWarnings("unchecked")
		public List<Conta> listarConta(){
			
			em.getTransaction().begin();
			Query consulta = em.createQuery("select conta from Conta conta");
			List<Conta> conta = consulta.getResultList();
			em.getTransaction().commit();
			emf.close();
			return conta;

		}
		
		public Conta consultarPorId(Conta id) {
			
			em.getTransaction().begin();
			Conta c = em.find(Conta.class, id);
			em.getTransaction().commit();
			emf.close();
			return c;
		}
	}