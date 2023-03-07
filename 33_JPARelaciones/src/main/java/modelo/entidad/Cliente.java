package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	/*
	 * Esta anotación está colocada delante del atributo fecha para 
	 * indicar c�mo debe ser convertido el campo FECHA de la base de 
	 * datos a el atributo fecha esta clase
	 * Admite uno de los siguientes argumentos:
	  @Temporal(TemporalType.DATE)
		Ignora la hora, quedando el campo acotado s�lo a la fecha.
		Ej: 2021-02-07
      @Temporal(TemporalType.TIME)
		Ignora la fecha, quedando el campo acotado s�lo a la hora.
		Ej: 20:44:34
	  @Temporal(TemporalType.TIMESTAMP)
		Tiene en cuanta la fecha y la hora.
		Ej: 2021-02-07 20:44:34
	 */
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;//Date del paquete java.util
	
	/*
	 * En este caso los atributos de Direccion van a estar como campos dentro de la tabla Cliente. 
	 * De esta manera, tenemos que usar la anotacion @Embedded para decirle a JPA que no hay una 
	 * tabla especifica para Direccion.
	 * Tambien debemos de anotar la clase Direccion de manera correcta
	 */
	@Embedded
	private Direccion direccion;

	
	// Relacion de "uno a uno" (Cliente - Datos Bancarios).
	//--------------------------------------
	// Siempre tenemos dos tipos de relaciones, unidireccional y bidireccional:
	// 	a) Unidireccional -> Solo una de las clases tiene una referencia sobre la otra
	// 	b) Bidireccional -> Las dos clases tienen referencias una con la otra. Este tipo
	//	es el que veremos en estos ejemplos
		
	// @OneToOne es la anotacion que debemos de colocar en el atributo que
	// queremos hacer relación "uno a uno", solo es obligatorio ponerlo en una de las 
	// dos clases, pero si lo ponemos en las dos hacemos la relacion bidireccional, 
	// es decir, ambas entidades se ven. 
	
	// Solo es obligario ponerla en el lado que tenga la foreign Key (FK) en caso de hacerlo
	// unidireccional. Si la hacemos bidireccional, entonces debemos poner @OneToOne
	// en ambas clases, y especificar quien tiene la FK con la anotaci�n @JoinColumn
	// (ver la clase Datos Bancarios)
	
	// Argumentos de @OneToOne (aplicables a otro tipo de relaciones):
	//	 a) CASCADE, representan como deben de comportarse los objetos
	//		a los cuales estamos referenciado desde este objeto. Es optativo,
	//		pero a tener muy en cuenta en caso de que queramos que al guardar
	//		un objeto, se guarde tambien los objetos a los cuales estemos referenciando
	//		Tenemos varios tipos de cascades, los m�s comunes:
	
	//   	1- CascadeType.ALL, siempre que hagamos cualquier accion
	// 		sobre un cliente, reaccionamos de igual manera con 
	// 		sus datos bancarios, por ejemplo si borramos un cliente
	// 		borramos sus datos bancarios asociados, si damos de alta
	// 		un cliente, daremos tambien de alta sus datos bancarios 
	//		asociados. (Este caso ser� en nuestro ejemplo)

	// 		2- CascadeType.PERSIST, solo en caso de que demos de alta un cliente
	//		daremos de alta sus datos bancarios
	
	//		3- CascadeType.REMOVE, solo en caso de que demos de baja un cliente
	//		daremos de baja sus datos bancarios
			
	//   b) mappedBy, hay que decirle con cual de todos los
	// 		posibles atributos de tipo cliente que tiene la clase 
	// 		DatosBancarios, es el con el que nos estamos relacionando
	// 		(en este caso solo hay uno)
	
	@OneToOne(mappedBy = "cliente", cascade=CascadeType.ALL)
	private DatosBancarios datosBancarios;
	
	// Relacion de "uno a muchos"
	//---------------------------
	// Esta anotacion en este extremo es para hacer relaciones bidireccionales.
	// La anotacion que es obligatoria es la que tiene la FK, es decir, la clase
	// Pedidio. 
	
	// Este cascade hace que cuando demos de alta o baja un cliente, lo hagamos
	// tambien de sus pedidos asociados. OJO! con esto porque podemos perder
	// informaci�n de pedidos.
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL) 
	private List<Pedido> pedidos;
	
	// Relacion de "muchos a muchos"
	//------------------------------
	// En este tipo de relaciones se nos creará una tabla intermedia automáticamente
	// con las FK a las PK de las otras tablas.
	// Es una relacion que muchas veces es mejor crear una entidad nueva intermedia
	// y hacer relaciones 1 a N y N a 1 con esa entidad nueva creada, porque así
	// podemos crear esa tabla intermedia a nuestro gusto, con los atributos
	// que queramos. 
	// Si hacemos una relación ManyToMany se nos creara esta tabla intermedia, 
	// pero no podremos modificar sus campos.

	// OJO! CascadeType.ALL es PELIGROSISIMO, ya que 
	// si borramos un cliente, borraremos tambien sus comerciales
	// asociados, y seguramente esos comerciales sean usados por
	// otros clientes
	@ManyToMany(mappedBy="clientes", cascade=CascadeType.PERSIST) 
	private List<Comercial> comerciales;	

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
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
