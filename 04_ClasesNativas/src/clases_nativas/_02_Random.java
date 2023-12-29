package clases_nativas;

import java.util.Random;

public class _02_Random {
	public static void main(String[] args) {
		
		//Con la clase random podemos generar primitivos aleatorios de manera sencilla
		Random rd = new Random();
		
		//Mirar documentación para ver lo que hace
		int numeroEntero = rd.nextInt(1, 11);//generando un numero entre el 1 y el 10
		System.out.println("Numero aleatorio: " + numeroEntero);
		
		double numeroDouble = rd.nextDouble(1.0, 100.0);
		System.out.println("Numero double aleatorio: " + numeroDouble);
		
		//Son llamadas numeros pseudoaleatorios ya que se basan siempre en una semilla
		//incial
		Random rdSemilla = new Random(1000);
		//En este caso, como la semilla es igual en el objeto Random
		//siempre generara los mismos números aleatorios
		numeroEntero = rdSemilla.nextInt(1, 11);
		System.out.println("Numero aleatorio: " + numeroEntero);
		numeroDouble = rdSemilla.nextDouble(1.0, 100.0);
		System.out.println("Numero double aleatorio: " + numeroDouble);
		
	}
}
