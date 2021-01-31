package test;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.PersonaDao;

public class _05_BorrarPersonaJPA {
	public static void main(String[] args) {
		PersonaDao pd = new PersonaDao();
		
		pd.borrar(1);
		
		System.out.println("Persona borrada");
		
		List<Persona> listaPersonas = pd.listar();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("Fin de borrar persona");
	}
}
