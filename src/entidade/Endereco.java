package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_endereco")
	private Integer id;
	@Column(name = "rua")
	private String rua;
	@Column(name = "numero")
	private String numero;
	@Column(name = "complemento")
	private String complemento;
	
	public Endereco() {
		super();
	}

	public Endereco(String rua, String numero, String complemento, Integer id) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.id = id;
	}




	public Endereco(Integer id, String rua, String numero, String complemento) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Endereco(String rua, String numero, String complemento) {
		super();
		
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + "]";
	}
	
	

}
