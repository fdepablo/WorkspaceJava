package prueba;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaJPA;
import modelo.persistencia.interfaces.DaoPersona;

public class _05_BorrarPersonaJPA {
	public static void main(String[] args) {
		DaoPersona pd = new DaoPersonaJPA();
		
		pd.borrar(1);
		
		System.out.println("Persona borrada");
		
		List<Persona> listaPersonas = pd.listar();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("Fin de borrar persona");
	}
}
