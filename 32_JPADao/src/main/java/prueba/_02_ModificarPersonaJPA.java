package prueba;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaJPA;
import modelo.persistencia.interfaces.DaoPersona;

public class _02_ModificarPersonaJPA {
	public static void main(String[] args) {
		DaoPersona pd = new DaoPersonaJPA();
		
		Persona persona = new Persona();
		persona.setNombre("Peter Dao");
		persona.setEdad(45);
		persona.setPeso(125);
		persona.setId(1);
		
		pd.modificar(persona);
		
		System.out.println("Persona modificada");
	}
}
