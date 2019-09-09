package teste;

import java.util.List;

import ControlerImpl.PessoaControlerImpl;
import daoImpl.ContaImpl;
import daoImpl.EnderecoImpl;
import daoImpl.PessoaImpl;
import entidade.Conta;
import entidade.Endereco;
import entidade.Pessoa;

public class Teste_2 {

	public static void main(String[] args) {
		
		///////////------- CADASTRA ------//////////////
		
//		Endereco end = new  Endereco("Rua Morais Santos","10","apt");
//		Conta con = new Conta(2311,10000.00,2000.00);
//		
//		Pessoa p = new Pessoa("Wanderson Alves de Araujo","M","033.150.455-10",end,con);
//		
//		PessoaControlerImpl dao = new PessoaControlerImpl();
//		dao.salvar(p);
	
///////////////////////////////////////////////////////////////		
		
//		///////////------- LISTAR ------//////////////

//		PessoaControlerImpl dao = new PessoaControlerImpl();
//		
//		List<Pessoa> contas = dao.listarPessoa();
//		
//		for (Pessoa pessoa : contas) {
//			System.out.println("Nome: " + pessoa.getNome()+" - Sexo: " + pessoa.getSexo()+" - CPF: " + pessoa.getCpf() + " - Endereco: " +
//					pessoa.getEndereco().getRua() + " - Nº: "+ pessoa.getEndereco().getNumero() + " " + pessoa.getEndereco().getComplemento()
//					+ " - Nº-conta: " + pessoa.getConta().getNumero() + " - Saldo: " + pessoa.getConta().getSaldo() + " - Limite: " 
//					+ pessoa.getConta().getLimite());
//		}
		
		
//////////////////////////////////////////////////////////////
		
		///////////------- LISTAR POR ID------//////////////
//		
		
//		PessoaControlerImpl dao = new PessoaControlerImpl();
//		
//		Pessoa p = dao.consultarId(1);
//		
//		System.out.println(p.getNome());
//	
		
//////////////////////////////////////////////////////////////
		
///////////------- ATUALIZAR ------//////////////		
		
//		PessoaControlerImpl dao = new PessoaControlerImpl();
//		
//		Pessoa p = dao.consultarId(1); // primeiro ele consulta o id, para depois atualizar
//		
//		p.setNome("Deyvisson Mendes de Araujo");
//		dao.atualizarPessoa(p);
//		

//////////////////////////////////////////////////////////////
		
///////////------- REMOVER ------//////////////		
		
//		PessoaControlerImpl dao = new PessoaControlerImpl();
//		
//		Pessoa p = dao.consultarId(3);
//		dao.removerPessoa(p);
		
	}
}