package test;

import modelo.entidad.Persona;
import modelo.persistencia.PersonaDao;

public class _01_CrearPersonaJPA {
	public static void main(String[] args) {
		PersonaDao pd = new PersonaDao();
		
		Persona persona = new Persona();
		persona.setNombre("Bud Spencer Dao");
		persona.setEdad(45);
		persona.setPeso(125);
		
		pd.insertar(persona);
		
		System.out.println("Persona creada");
	}
}
