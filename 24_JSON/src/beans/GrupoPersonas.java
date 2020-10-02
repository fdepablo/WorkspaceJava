package beans;

import java.util.ArrayList;
import java.util.List;

public class GrupoPersonas {
	private List<Persona> personas;

	public GrupoPersonas() {
		personas = new ArrayList<Persona>();
	}
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
}
