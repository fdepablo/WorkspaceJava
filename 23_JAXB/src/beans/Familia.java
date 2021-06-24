package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * <personas>
 * 	<persona>
 * 		......
 * 		......
 * 	</persona>
 * 
 * 	<persona>
 * 		......
 * 		......
 * 	</persona>
 * </personas>
 * 
 */

@XmlRootElement(name="familia")
public class Familia {
	private String nombre;
	private String ciudad;
	private List<Persona> personas;

	public Familia() {
		personas = new ArrayList<Persona>();
	}
	
	//Establezco que cada elemento del array se serialice a una etiqueta xml cuyo nombre
	//sea "persona"
	@XmlElement(name = "miembro")
	//Podemos crear una etiqueta que envuelva las etiquetas persona, si no la ponemos saldran
	//las etiquetas "persona" al mismo nivel que la familia, de esta manera agrupamos todos
	//los "miembro" en la etiqueta "miembros"
	@XmlElementWrapper(name = "miembros")
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
