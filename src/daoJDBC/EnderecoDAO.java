package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Endereco;
import util.Conexao;
import util.SQL;

public class EnderecoDAO {
	
	Conexao conexao = new Conexao();
	Connection conn = conexao.getConnection();
	
	public void InserirEndereco(Endereco endereco) {
			
		PreparedStatement pstm = null;
	
		try {
			
			pstm = conn.prepareStatement(SQL.Inserir_Endereco);
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getNumero());
			pstm.setString(3, endereco.getComplemento());
			pstm.execute();
			
			
		}catch(SQLException e) {
			System.out.println("Erro ao inserir no banco " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
		
	}
	
	public void ExcluirEndereco(int idEndereco) {
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Excluir_Endereco);
			pstm.setInt(1, idEndereco);
			pstm.execute();
			
		}catch(SQLException e) {
			System.out.println("Endereço excluido com Sucesso " + e.getMessage());
			
		}finally{
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
				
	}
	public void AtualizarEndereco(Endereco endereco) {
		
		PreparedStatement pstm = null;
		
		try {
		
			pstm = conn.prepareStatement(SQL.Atualizar_Endereco);
			pstm.setString(1, endereco.getRua());
			pstm.setString(2, endereco.getNumero());
			pstm.setString(3, endereco.getComplemento());
			pstm.setInt(4, endereco.getId());
			pstm.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(" Erro ao Atualizar o banco " + e.getMessage());
			
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
		
	}
	
	public ArrayList<Endereco> listarEndereco(){
		
		ArrayList<Endereco> lista = new ArrayList<Endereco>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			
			pstm = conn.prepareStatement(SQL.Listar_Endereco);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Endereco e = new Endereco();
				
				e.setId(rs.getInt("id_endereco"));
				e.setRua(rs.getString("rua"));
				e.setNumero(rs.getString("numero"));
				e.setComplemento(rs.getString("complemento"));

				lista.add(e);
			}
			
			
		}catch(SQLException e) {
			System.out.println("Nao foi possivel Listar" + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fechar_pstm_rs(pstm, rs);
		}
		
		return lista;
		
	}

}
