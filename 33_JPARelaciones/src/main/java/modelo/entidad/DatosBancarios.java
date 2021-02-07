package modelo.entidad;

import javax.persistence.CascadeType;
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

	// Relación de uno a uno
	//-----------------------
	// Al ser una relacion bidireccional, tambien ponemos la anotacion @OneToOne sobre
	// este atributo
	// Este cascade no lo ponemos, ya que no queremos actuar sobre el cliente en caso de hacer 
	// alguna accion con los datos bancarios
	@OneToOne/*(cascade= CascadeType.ALL)*/ 
		
	// Mediante @JoinColumn establecemos que la FK estará en esta tabla (datos_bancarios).
	// Le podemos dar el nombre de la columna y a que columna de la tabla
	// cliente estamos referenciando, que normalmente es la Primary Key (PK)
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
