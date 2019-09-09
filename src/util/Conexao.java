package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexao {
	
	private static final String url_conection = "jdbc:mysql://localhost:3306/teste";
	private static final String usuario = "root";
	private static final String senha ="8896";
	
	
	public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn =  DriverManager.getConnection(url_conection,usuario,senha);
			
			
		}catch(Exception e){
			System.out.println(" Erro na conexao com o banco " + e.getMessage());
		}
		return conn;
		
	}
	
	public void fecharConexao(Connection conn) {
		
		try {
			conn.close();
		}catch(SQLException e) {
			System.out.println("Erro ao fechar o banco " + e.getMessage());
		}
		
		
	}
	
	public void fecharStatement(PreparedStatement pstm) {
		
		if(pstm == null)return;
		try {
			pstm.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fecharResultSet(ResultSet rs) {
		
		if(rs == null)return;
		try {
			rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void fechar_pstm_rs(PreparedStatement pstm, ResultSet rs) {
		fecharStatement(pstm);
		fecharResultSet(rs);
	}

}
