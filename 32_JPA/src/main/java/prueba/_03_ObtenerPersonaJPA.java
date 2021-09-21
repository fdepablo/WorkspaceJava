package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _03_ObtenerPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		//Como ahora no vamos a modificar la BBDD no tenemos porque abrir un entorno de transaccionalidad
		//las busquedas por defecto son por clave primaría
		Persona p = em.find(Persona.class, 1);
		System.out.println(p);
		
		em.close();
		System.out.println("Fin de obtener persona");
	}
}
