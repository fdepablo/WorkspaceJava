package modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "datos_bancarios")
public class DatosBancarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String banco;
	@Column(name = "numero_cuenta")
	private Integer numeroTC;

	@OneToOne
	@JoinColumn(name = "fk_id_cliente", referencedColumnName = "id")
	private Cliente cliente;

	public DatosBancarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosBancarios(Integer id, String banco, Integer numeroTC,
			Cliente cliente) {
		super();
		this.id = id;
		this.banco = banco;
		this.numeroTC = numeroTC;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Integer getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(Integer numeroTC) {
		this.numeroTC = numeroTC;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
