package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String telefono;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;//Date del paquete java.util
	
	@Embedded
	private Direccion direccion;

	@OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL)
	private DatosBancarios datosBancarios;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL) 
	private List<Pedido> pedidos;
	
	@ManyToMany(mappedBy="clientes", cascade=CascadeType.PERSIST) 
	private List<Comercial> comerciales;	

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String telefono,
			DatosBancarios datosBancarios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.datosBancarios = datosBancarios;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DatosBancarios getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(List<Comercial> comerciales) {
		this.comerciales = comerciales;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
