package util;

public class SQL {
	
	//// ENDEREÇO /////
	
	public static final String Inserir_Endereco = 
			"insert into Endereco(rua, numero, complemento) values (?,?,?)";
	
	public static final String Excluir_Endereco =
			"delete from Endereco where id_endereco = ?";
	
	public static final String Atualizar_Endereco = 
			"update endereco set rua = ?, numero = ?, complemento = ? where id_endereco = ?";
	
	public static final String Listar_Endereco = "select * from endereco";


	//// CONTA //////
	
	public static final String Inserir_Conta = 
			"insert into Conta(numero, saldo, limite) values (?,?,?)";
	
	public static final String Excluir_Conta =
			"delete from Conta where id = ?";
	
	public static final String Atualizar_Conta =
			"update conta set numero = ?, saldo = ?, limite = ? where id = ?";
	
	public static final String ListarConta = 
			"select * from conta";

	
	public static final String Inserir_Pessoa =
			"insert into pessoa(nome, sexo, cpf, id_endereco, id_conta) values (?,?,?,?,?)";
	
	public static final String Excluir_Pessoa = 
			"delete from pessoa where id_pessoa = ?";
	
	public static final String Atualizar_Pessoa =
			"update pessoa set nome = ?, sexo = ?, cpf = ?, id_endereco = ?, id_conta = ? where id_pessoa = ?";
	
	public static final String ListarPessoa = 
			"select p.id_pessoa, p.nome, p.cpf, p.sexo, r.id_endereco, r.rua, r.numero, r.complemento, c.id, c.numero, c.saldo, c.limite\r\n" + 
			"from pessoa p join endereco r\r\n" + 
			"on p.id_endereco = r.id_endereco\r\n" + 
			"join conta c\r\n" + 
			"on p.id_conta = c.id";
	
}