package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _02_ModificarPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("Chiquito");
		persona.setEdad(89);
		persona.setPeso(120);
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(persona);
		et.commit();
		
		System.out.println("Fin de modificar persona");
	}
}
