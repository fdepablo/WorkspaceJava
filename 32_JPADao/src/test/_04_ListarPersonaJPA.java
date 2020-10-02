package test;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.PersonaDao;

public class _04_ListarPersonaJPA {
	public static void main(String[] args) {
		PersonaDao pd = new PersonaDao();
		
		List<Persona> listaPersonas = pd.listar();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("Fin de listar personas");
	}
}
