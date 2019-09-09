package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidade.Pessoa;

public class PessoaImpl {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public PessoaImpl() {
		
		emf = Persistence.createEntityManagerFactory("testePU");
		em = emf.createEntityManager();
		
	}

	public void salvar(Pessoa pessoa) {
		
		if(pessoa.getNome() == null || pessoa.getNome().trim().equals("")) {
			System.out.println("Erro! Porfavor digite seu nome completo!");
		}else {
			
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		emf.close();
		
		System.out.println("Cadastrado com Sucesso!");
		}	
	}
	
	public void remover(Pessoa pessoa) {
		
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
		emf.close();
		
		System.out.println("Removido com Sucesso!");
	}
	public void atualizar(Pessoa pessoa) {
		
		em.getTransaction().begin();
		em.merge(pessoa);
		em.getTransaction().commit();
		emf.close();
		
		System.out.println("Atualizado com Sucesso! - " + pessoa.getNome());
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoa(){
		
		em.getTransaction().begin();
		Query consulta = em.createQuery("select pessoa from Pessoa pessoa");
		List<Pessoa> conta = consulta.getResultList();
		em.getTransaction().commit();
		emf.close();
		return conta;

	}
	
	public Pessoa consultarPorId(int id) {
		
		em.getTransaction().begin();
		Pessoa pessoas = em.find(Pessoa.class, id);
		em.getTransaction().commit();
		emf.close();
		return pessoas;
	}
}