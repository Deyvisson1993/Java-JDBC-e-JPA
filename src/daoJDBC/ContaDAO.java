package daoJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Conta;
import util.Conexao;
import util.SQL;

public class ContaDAO {
	
	Conexao conexao = new Conexao();
	Connection conn = conexao.getConnection();
	
	public void InserirConta(Conta conta) {
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Inserir_Conta);
			
			pstm.setInt(1, conta.getNumero());
			pstm.setDouble(2, conta.getSaldo());
			pstm.setDouble(3, conta.getLimite());
			pstm.execute();
						
		}catch(SQLException e) {
			System.out.println("Erro ao Inserir uma Contata " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
		
	}
	
	public void ExcluirConta(int idContato) {
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Excluir_Conta);
			
			pstm.setInt(1, idContato);
			pstm.execute();
			
		}catch(SQLException e) {
			System.out.println("Nao foi Possivel Excluir a Conta " + e.getMessage());
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
	}
	
	public void AtualizarConta(Conta conta) {
		
		PreparedStatement pstm = null;
		
		try {
			
			pstm = conn.prepareStatement(SQL.Atualizar_Conta);
			pstm.setInt(1, conta.getNumero());
			pstm.setDouble(2, conta.getSaldo());
			pstm.setDouble(3, conta.getLimite());
			pstm.setInt(4, conta.getId());
			pstm.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			conexao.fecharConexao(conn);
			conexao.fecharStatement(pstm);
		}
	}
	
	public ArrayList<Conta> ListarConta(){
		
		ArrayList<Conta> listar = new ArrayList<Conta>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			
			pstm = conn.prepareStatement(SQL.ListarConta);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Conta c = new Conta();
				
				
				c.setId(rs.getInt("id"));
				c.setNumero(rs.getInt("numero"));
				c.setSaldo(rs.getDouble("saldo"));
				c.setLimite(rs.getDouble("limite"));
				
				listar.add(c);
				
				}
				
			}catch (SQLException e) {
				System.out.println("Não foi possivel Listar a Conta" + e.getMessage());
			}finally {
				conexao.fecharConexao(conn);
				conexao.fechar_pstm_rs(pstm, rs);
			}
					
			return listar;
	}
}