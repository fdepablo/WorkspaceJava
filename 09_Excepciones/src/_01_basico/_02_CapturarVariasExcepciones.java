package _01_basico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _02_CapturarVariasExcepciones {

	public static void main(String[] args) {
		//Vamos a hacer un programa que pida dos números por pantalla
		//y devulva su división entera
		
		//Este programa de aquí, aunque sencillo esta sujeto a muchos errores
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numerador: ");
		int numerador = sc.nextInt();
		System.out.println("Introduzca el denominador: ");
		int denominador = sc.nextInt();
		int resultado = numerador/denominador;
		System.out.println(resultado);
		*/

		
		boolean estaCorrecto = false;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Introduzca el numerador: ");
				int numerador = sc.nextInt();
				System.out.println("Introduzca el denominador: ");
				int denominador = sc.nextInt();
				int resultado = numerador/denominador;
				System.out.println(resultado);
				estaCorrecto = true;
			}catch(InputMismatchException ime) {
				System.out.println("Ha introducido una cadena en vez de un número");
			}catch(ArithmeticException ae) {
				//Podemos tener tantos bloques catch como queramos, y en cada
				//bloque capturar el tipo de excepción que necesitemos
				System.out.println("No aceptamos divisiones por cero");
			}
		}while(!estaCorrecto);
	}

}
