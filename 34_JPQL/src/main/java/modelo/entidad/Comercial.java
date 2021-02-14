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

	//Solo hacemos cascade cuando damos de alta
	@ManyToMany(cascade=CascadeType.PERSIST)
	//En este caso @JoinTable daremos instrucciones para crear la tabla intermedia
	//que JPA creara para hacer la realcion "Many to Many" 
	//Usa los siguientes parametros
	//1. name -> El nombre de la tabla intermedia
	//2. joinColumns -> las columnas FK y PK que aporta esta entidad (COMERCIAL)
	//3. inverseJoinColumns -> las columnas FK y PK que me aporta la otra Entidad (CLIENTE)
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
