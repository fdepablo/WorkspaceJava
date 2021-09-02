package main;

import java.util.Scanner;
import javax.persistence.*;

public class Main {
	private static Scanner lector;
	private static EntityManagerFactory factoria;
	private static EntityManager em;
	//private static final String pattern = "\\d{1,4}";


	public static void main(String[] args) {
		factoria = Persistence.createEntityManagerFactory("JPAFerreteria");
		em = factoria.createEntityManager();
		
	
		// Cerramos la conexion con la BD y el Lector.
		em.close();
		lector.close();
	}


}