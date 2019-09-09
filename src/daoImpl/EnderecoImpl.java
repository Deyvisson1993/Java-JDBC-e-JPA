package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Endereco;



public class EnderecoImpl {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	public EnderecoImpl() {
		
		emf = Persistence.createEntityManagerFactory("testePU");
		em = emf.createEntityManager();
		
	}
	
	public void salvar(Endereco endereco) {
		
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	public void remover(Endereco endereco) {
		
		em.getTransaction().begin();
		em.remove(endereco);
		em.getTransaction().commit();
		emf.close();
		
	}
	public void atualizar(Endereco endereco) {
		
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		emf.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> listarEndereco(){
		
		em.getTransaction().begin();
		Query consulta = em.createQuery("select endereco from Endereco endereco");
		List<Endereco> endereco = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return endereco;

	}
	
	public Endereco consultarPorId(Endereco id) {
		
		em.getTransaction().begin();
		Endereco e = em.find(Endereco.class, id);
		em.getTransaction().commit();
		emf.close();
		return e;
		
	}
}