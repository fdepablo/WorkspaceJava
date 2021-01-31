package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import modelo.entidad.Persona;

public class _00_ProbarConexioinPersonaJPA {
	public static void main(String[] args) {
		//este ejemplo es para probar la conexion
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("PruebaJPA");
		EntityManager em = factoria.createEntityManager();
	}
}
