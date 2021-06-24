package beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
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

@XmlRootElement(name="personas")
public class GrupoPersonas {
	private List<Persona> personas;

	public GrupoPersonas() {
		personas = new ArrayList<Persona>();
	}
	
	//Establezco que cada elemento del array se serialice a una etiqueta xml cuyo nombre
	//sea "persona"
	@XmlElement(name = "persona")
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
