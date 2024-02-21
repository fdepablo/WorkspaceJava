package entidad;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

// El objetivo de JAXB es trabajar de una manera sencilla con XML
//para serializar y deserializar objetos.

// Serializar es cuando convertimos un objeto a cadena (String)
// Deserializar es el proceso inverso, cuando convertimos una cadena
//a objeto.

// Cuando trabajamos con JAXB para serializar y deserializar objetos necesitamos
//utilizar anotaciones para realizar la funcionalidad.

// Primero de todo, tenemos anotaciones a nivel de clase. Vamos a verlas a 
//continuación.

// Con esta anotación estamos estableciendo el nombre de el nodo en el XML
//Es una anotación obligatoria en JAXB
// Por defecto pondría el nombre de la clase en lowerCamelCase, pero si usamos 
//el atributo "name" dentro de la anotacón podemos cambiar el nombre del nodo.
@XmlRootElement(name="persona")
// Por defecto, cuando serializamos un objeto, todos los atributos del objeto se 
//serializan a nodos elemento.

// Podemos hacer dichos nodos elemento salgan en un determinado orden con la siguiente
//anotación. Sería opcional.
@XmlType(propOrder = {
		"idPersona",
	    "nombre",
	    "apellido",
	    "edad",
	    "direccion"
	})
public class Persona {
	// Como hemos dicho antes, JAXB convertirá todos los atributos en nodos elemento
	//en el XML. El nombre del nodo elemento será el del atributo.
	private int idPersona;
	private String nombre;
	private String apellido;
	private int edad;
	// Podemos también tener referencias de otras clases, no solo primitivos
	//dicha clase debera de estar anotada correctamente con anotaciones
	//JAXB
	private Direccion direccion;
	
	// JAXB necesita del constructor por defecto de java para poder funcionar.
	//Realmente necesita que la clase tenga la estructura JavaBean
	public Persona() {
		
	}
	
	public Persona(int id, String nombre, String apellido, int edad) {
		this.idPersona = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	// Además de anotaciones a nivel de clase, tenemos anotaciones a nivel de 
	//métodos como @XmlAttribute, @XmlElement y @XmlTransient
	//Siempre las pondremos en el método accesor o método "get"
	
	// Esta anotación hace que el atributo de la persona se serialize 
	//como atributo en el XML.
	//Ej: <persona id="1">
	@XmlAttribute(name = "id")
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//Esta anotación es opcional, sirve para cambiar el nombre del nodo elemento
	//cuando se serialice la información. En este ejemplo, el nodo elemento
	//resultante se llamará "apellidos" en lugar de "apellido"
	@XmlElement(name="apellidos")
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	// Esta anotación es opcional, sirve para si en algún momento no queremos 
	//serializar un atributo, es decir, el nodo no aparecerá en el XML resultante.
	//@XmlTransient
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", direccion=" + direccion + "]";
	}	
}
