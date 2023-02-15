package prueba;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaJPA;
import modelo.persistencia.interfaces.DaoPersona;

public class _03_ObtenerPersonaJPA {
	public static void main(String[] args) {
		DaoPersona pd = new DaoPersonaJPA();
		
		Persona p = pd.buscar(1);
		System.out.println(p);
		
		System.out.println("Fin obtener persona");
	}
}
