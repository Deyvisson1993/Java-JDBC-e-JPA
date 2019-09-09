package teste;

import java.util.ArrayList;
import java.util.List;

import controler.PessoaControl;
import daoJDBC.ContaDAO;
import daoJDBC.EnderecoDAO;
import daoJDBC.PessoaDAO;
import entidade.Conta;
import entidade.Endereco;
import entidade.Pessoa;

public class Teste {

	public static void main(String[] args) {
		
///////////////// ------ CADASTRA -------/////////////////		
/*
 * Sempre verificar o Id de qualquer Ação
 * 
 */
		
		
		Endereco end = new Endereco(1,"Rua dos Jasmins","90","casa");
		Conta con = new Conta(1,4432,1360.03,9004.55);
		Pessoa p = new Pessoa("Deyvisson Mendes","M","081.422.324-50",end,con);
		
		PessoaControl control = new PessoaControl();
		control.cadastraPessoa(p);

		System.out.println(" -------------Cadastrado com Sucesso ------");

///////////////////////////////////////////////////////////		
		
/////////////// -------- ATUALIZAR ------////////////////
	/*
	 * Sempre verificar o Id de qualquer Ação
	 * 
	 */		
		
//		Endereco e = new Endereco(1,"Rua Ana Nery","90","casa");
//		Conta c = new Conta(1,4432,3000.0,7000.0);
//		Pessoa pe = new Pessoa("tayline Roberta","F","001.230.254-50",e,c,1);
//		
//		PessoaControl control1 = new PessoaControl();
//		control1.atualizarPessoa(pe);
//		
//		System.out.println(" -------------Atualizado com Sucesso ------");

/////////////////////////////////////////////////////////////////////////
		
///////////// ------ EXCLUIR   ------------//////////////////////////

//		PessoaControl control = new PessoaControl();
//		control.excluirPessoa(1);
//		
//		System.out.println(" -------------Excluido com Sucesso ------");

///////////////////////////////////////////////////////////////////////////
		
////////// ------------- CONSULTAR DADOS  ---------/////////////////////	
		
//		PessoaControl control = new PessoaControl();
//		List<Pessoa> listar = new ArrayList<Pessoa>();
//		
//		listar = control.consultarTodos();
//		
//		for(int i = 0; i < listar.size(); i++) {
//			System.out.println(listar.get(i));
//		}
//		
	}
}
