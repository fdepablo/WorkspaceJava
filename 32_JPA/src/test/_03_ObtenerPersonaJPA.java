package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _03_ObtenerPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		Persona p = em.find(Persona.class, 1);
		System.out.println(p);
		
		System.out.println("Fin de obtener persona");
	}
}
