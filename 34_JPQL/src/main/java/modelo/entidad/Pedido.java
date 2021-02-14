package modelo.entidad;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	// Relación de muchos a uno
	//--------------------------
	// Usaremos la etiqueta @ManyToOne, con esta etiqueta sería suficiente
	// para hacer una relacion unidireccional.
	// OJO con los cascades en esta etiqueta, poner un CascadeType.ALL hace que al
	// borrar un pedido se borraría tambien el cliente de dicho pedido... MUY PELIGROSO
	@ManyToOne//(cascade=CascadeType.ALL) 
	// En una relacion de "uno a muchos", la FK siempre esta en el lado de "Muchos", en una
	// relacion de "uno a uno" podemos poner la FK donde queramos.
	// Por lo tanto la @JoinColumn siempre estará en este lado en este tipo de relaciones
	@JoinColumn(name="fk_id_cliente", referencedColumnName="id")
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Integer id, String codigo, Date fecha, Cliente cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
