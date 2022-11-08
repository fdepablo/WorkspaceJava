package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Comercial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="comerciales_clientes",
			   joinColumns= { @JoinColumn(name="fk_id_comercial", referencedColumnName="id") }, //FK que aporta Comercial
			   inverseJoinColumns= { @JoinColumn(name="fk_id_cliente", referencedColumnName="id")}) //FKs que aportan el resto de entidades
	private List<Cliente> clientes;

	public Comercial() {
		super();
	}

	public Comercial(Integer id, String nombre, List<Cliente> clientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clientes = clientes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
