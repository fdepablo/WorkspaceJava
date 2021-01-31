package test;

import modelo.entidad.Persona;
import modelo.persistencia.PersonaDao;

public class _03_ObtenerPersonaJPA {
	public static void main(String[] args) {
		PersonaDao pd = new PersonaDao();
		
		Persona p = pd.buscar(1);
		System.out.println(p);
		
		System.out.println("Fin obtener persona");
	}
}
