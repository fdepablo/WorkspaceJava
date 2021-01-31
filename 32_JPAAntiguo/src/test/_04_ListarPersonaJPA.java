package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _04_ListarPersonaJPA {
	public static void main(String[] args) {
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
		
		List<Persona> listaPersonas = em.createQuery("from Persona p").getResultList();
		for(Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("Fin de listar personas");
	}
}
