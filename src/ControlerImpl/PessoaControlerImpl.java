package ControlerImpl;

import java.util.ArrayList;
import java.util.List;

import daoImpl.PessoaImpl;
import entidade.Conta;
import entidade.Endereco;
import entidade.Pessoa;

public class PessoaControlerImpl {
	
	public void salvar(Pessoa pessoa) {
		
		PessoaImpl dao = new PessoaImpl();
		
		Pessoa inserirPessoa = new Pessoa();
		Endereco inserirEndereco = new Endereco();
		Conta inserirConta = new Conta();
		
		inserirEndereco.setId(pessoa.getEndereco().getId());
		inserirEndereco.setRua(pessoa.getEndereco().getRua());
		inserirEndereco.setNumero(pessoa.getEndereco().getNumero());
		inserirEndereco.setComplemento(pessoa.getEndereco().getComplemento());
		
		inserirConta.setId(pessoa.getConta().getId());
		inserirConta.setNumero(pessoa.getConta().getNumero());
		inserirConta.setSaldo(pessoa.getConta().getSaldo());
		inserirConta.setLimite(pessoa.getConta().getLimite());
		
		inserirPessoa.setNome(pessoa.getNome());
		inserirPessoa.setSexo(pessoa.getSexo());
		inserirPessoa.setCpf(pessoa.getCpf());
		inserirPessoa.setEndereco(inserirEndereco);
		inserirPessoa.setConta(inserirConta);
		
		dao.salvar(inserirPessoa);
	}
	
	public List<Pessoa> listarPessoa(){
		
		PessoaImpl dao = new PessoaImpl();
		
		List<Pessoa> consultar = new ArrayList<Pessoa>();
		consultar = dao.listarPessoa();
		return consultar;
	}
	
	public Pessoa consultarId(int id) {
		
		PessoaImpl dao = new PessoaImpl();
		Pessoa p = dao.consultarPorId(id);
		return p;
		
	}
	
	public void atualizarPessoa(Pessoa pessoa) {
		
		PessoaImpl dao = new PessoaImpl();
		dao.atualizar(pessoa);
	}
	
	public void removerPessoa(Pessoa pessoa) {
		
		PessoaImpl dao = new PessoaImpl();
		Pessoa p = dao.consultarPorId(pessoa.getId());
		dao.remover(p);
	
	}
}