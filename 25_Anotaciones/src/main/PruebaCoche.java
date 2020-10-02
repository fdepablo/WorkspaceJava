package main;

import anotaciones.Autor;
import beans.Coche;

public class PruebaCoche {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Coche miCoche = new Coche("Ford", "Fiesta");
		System.out.println(miCoche);
		System.out.println("---------------------------------");
		
		// Accediendo a los datos de la anotación de la clase.
		Autor a2 = miCoche.getClass().getAnnotation(Autor.class);
		System.out.println("Nombre autor: " + a2.nombre());
		System.out.println("Dirección autor: " + a2.direccion());	
		
		// Accediendo a los datos de la anotación del método.
		/*
		 * La expresión miCoche.getClass() devuelve un objeto de tipo Class que 
		 * provee información sobre la clase a la que pertenece el objeto. 
		 * De esta forma, estamos también obteniendo información sobre el 
		 * método acelerar(), usando la expresión getMethod("acelerar"). 
		 * Concretamente, estamos accediendo a los datos de la anotación.
		 * 
		 * Reflection
		 */
		System.out.println("---------------------------------");
		Autor a1 = miCoche.getClass().getMethod("acelerar").getAnnotation(Autor.class);
		System.out.println("Nombre autor: " + a1.nombre());
		System.out.println("Dirección autor: " + a1.direccion());
	}
}
