package controler;

import java.util.ArrayList;

import daoJDBC.ContaDAO;
import daoJDBC.EnderecoDAO;
import daoJDBC.PessoaDAO;
import entidade.Conta;
import entidade.Endereco;
import entidade.Pessoa;

public class PessoaControl {
	
	public void cadastraPessoa(Pessoa pessoa) {
		
		PessoaDAO dao = new PessoaDAO();
		
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
		
		dao.InserirPessoa(inserirPessoa);
		
	}

	public ArrayList<Pessoa> consultarTodos(){
		
		PessoaDAO dao = new PessoaDAO();
		
		ArrayList<Pessoa> consultar = new ArrayList<Pessoa>();
		consultar = dao.ListarTodos();
		return consultar;
		
	}
	
	public void atualizarPessoa(Pessoa pessoa) {
		PessoaDAO dao = new PessoaDAO();
		dao.AtualizarPessoa(pessoa);
		
	}
	
	public void excluirPessoa(int pesssoa) {
		
		PessoaDAO dao = new PessoaDAO();
		EnderecoDAO dao1 = new EnderecoDAO();
		ContaDAO dao2 = new ContaDAO();
		
		dao.ExcluirPessoa(pesssoa);
		dao1.ExcluirEndereco(pesssoa);
		dao2.ExcluirConta(pesssoa);
		
	}

}
