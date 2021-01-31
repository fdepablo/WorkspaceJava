package prueba;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _01_CrearPersonaJPA {
	public static void main(String[] args) {
		
		//Siempre trabajamos con un objeto EntityManager
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		//notese que no le pongo el id ya que la bbdd me lo asignará
		Persona persona = new Persona();
		persona.setNombre("Bud Spencer");
		persona.setEdad(89);
		persona.setPeso(120);
		
		//Siempre que modifiquemos la bbdd, ya sea por inserts, updates, deletes, etc.
		//debemos de abrir un contexto de transaccionalidad
		EntityTransaction et = em.getTransaction();
		et.begin();//empezamos la transaccion
		em.persist(persona);//con este metodo, guardo el objeto persona en la tabla de bbdd
		et.commit();
		
		em.close();//cerrar el entity manager
		System.out.println("Persona creada");
	}
}
