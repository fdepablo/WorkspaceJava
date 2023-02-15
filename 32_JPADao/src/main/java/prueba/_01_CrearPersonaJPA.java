package prueba;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaJPA;
import modelo.persistencia.interfaces.DaoPersona;

public class _01_CrearPersonaJPA {
	public static void main(String[] args) {
		DaoPersona pd = new DaoPersonaJPA();
		
		Persona persona = new Persona();
		persona.setNombre("Bud Spencer Dao");
		persona.setEdad(45);
		persona.setPeso(125);
		
		pd.insertar(persona);
		
		System.out.println("Persona creada");
	}
}
