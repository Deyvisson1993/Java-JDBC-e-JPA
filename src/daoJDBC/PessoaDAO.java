package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Conta;
import entidade.Endereco;
import entidade.Pessoa;
import util.Conexao;
import util.SQL;

public class PessoaDAO {
	
	Conexao conexao = new Conexao();
	Connection conn = conexao.getConnection();
	
	public void InserirPessoa(Pessoa pessoa) {
		
		ContaDAO contato = new ContaDAO();		
		EnderecoDAO endereco = new EnderecoDAO();
		contato.InserirConta(pessoa.getConta());
		endereco.InserirEndereco(pessoa.getEndereco());
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Inserir_Pessoa);
			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getSexo());
			pstm.setString(3, pessoa.getCpf());
			pstm.setInt(4, pessoa.getEndereco().getId());
			pstm.setInt(5, pessoa.getConta().getId());
			pstm.execute();
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao Inserir Pessoa " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
	}

	public void ExcluirPessoa(int idPessoa) {
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Excluir_Pessoa);
			pstm.setInt(1, idPessoa);
			pstm.execute();
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao tentar excluir Pessoa " + e.getMessage());
			
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}		
	}
	
	public void AtualizarPessoa(Pessoa pessoa) {
		
		ContaDAO conta = new ContaDAO();		
		EnderecoDAO endereco = new EnderecoDAO();

		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Atualizar_Pessoa);
			pstm.setString(1, pessoa.getNome());
			pstm.setString(2, pessoa.getSexo());
			pstm.setString(3, pessoa.getCpf());
			pstm.setInt(4, pessoa.getEndereco().getId());
			pstm.setInt(5, pessoa.getConta().getId());
			pstm.setInt(6, pessoa.getId());
			pstm.executeUpdate();
			
			endereco.AtualizarEndereco(pessoa.getEndereco());
			conta.AtualizarConta(pessoa.getConta());
			
		}catch(SQLException e) {
			System.out.println("Erro ao tentar Atualizar Pessoa" + e.getMessage());
			
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
	}
	
	public ArrayList<Pessoa> ListarTodos(){
		
		ArrayList<Pessoa> listar = new ArrayList<Pessoa>();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.ListarPessoa);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Pessoa p = new Pessoa();
				Endereco e = new Endereco();
				Conta c = new Conta();
				
				p.setId(rs.getInt("id_pessoa"));
				p.setNome(rs.getString("nome"));
				p.setSexo(rs.getString("sexo"));
				p.setCpf(rs.getString("cpf"));
				
				e.setId(rs.getInt("id_endereco"));
				e.setRua(rs.getString("rua"));
				e.setNumero(rs.getString("numero"));
				e.setComplemento(rs.getString("complemento"));
				
				c.setId(rs.getInt("id_conta"));
				c.setNumero(rs.getInt("numero"));
				c.setSaldo(rs.getDouble("saldo"));
				c.setLimite(rs.getDouble("limite"));
				
				p.setConta(c);
				p.setEndereco(e);
				
				listar.add(p);
			}
			
		}catch(SQLException e) {
			System.out.println("nao foi possivel Listar Pessoa " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fechar_pstm_rs(pstm, rs);
		}
		
		
		
		
		return listar;
	}

}