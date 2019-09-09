package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column(name = "id_conta")
	private int id;
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "saldo")
	private double saldo;
	@Column(name = "limite")
	private double limite;
	
	
	public Conta() {
		super();
	}
	
	
	public Conta(int id, Integer numero, double saldo, double limite) {
		super();
		this.id = id;
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}

	public Conta(Integer numero, double saldo, double limite) {
		super();
		
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	public Conta(Integer numero, double saldo, double limite, int id) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}


	@Override
	public String toString() {
		return "Conta [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
	}
	
	

}
