package test;

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
		
		//para borrar una persona, debe de estar cacheada dentro del entity
		//manager, no podemos borrar una persona directamente
		//los objetos con los que trabajemos en el EntityManager
		//Se van a quedar cacheados hasta que cerremos el entitymanager
		int id = 1;
		Persona persona = em.find(Persona.class, id);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		//para borrar una persona, debe de estar cacheada dentro del entity
		//manager, no podemos borrar una persona directamente
		//los objetos con los que trabajemos en el EntityManager
		//Se van a quedar cacheados hasta que cerremos el entitymanager
		em.remove(persona);
		et.commit();
		
		System.out.println("Persona borrada");
		
		List<Persona> listaPersonas = em.createQuery("from Persona p").getResultList();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("Fin de borrar persona");
	}
}
