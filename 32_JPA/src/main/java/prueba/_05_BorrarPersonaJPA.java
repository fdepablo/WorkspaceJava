package prueba;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _05_BorrarPersonaJPA {
	public static void main(String[] args) {
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		//Para borrar una persona, debe de estar cacheada/gestionada dentro del Entity
		//Manager, no podemos borrar una persona directamente.
		//Los objetos con los que trabajemos en el EntityManager
		//se van a quedar cacheados hasta que cerremos el EM.
		int id = 1;
		Persona persona = em.find(Persona.class, id);
		
		//Abrimos transacción, ya que vamos a cambiar la BBDD
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(persona);//borramos la persona con el id que le hayamos dado y teniendola cacheada en el EM
		et.commit();
		
		System.out.println("Persona borrada");
		
		List<Persona> listaPersonas = em.createQuery("from Persona p").getResultList();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		em.close();
		System.out.println("Fin de borrar persona");
	}
}
