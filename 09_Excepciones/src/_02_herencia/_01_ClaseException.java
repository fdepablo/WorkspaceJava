package _02_herencia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _01_ClaseException {

	public static void main(String[] args) {
		// Aunque la clase padre de todas las clases sea la clase Objetc
		// Para las excepciones se considera la clase "Exception". Todas
		// excepciones que hemos trabajado:
		// NullPointerException
		// ArrayIndexOfBoundException
		// ArithmeticException
		// ...
		// Todas estás excepciones tienen como padre la clase Exception
		// Con esto queremos decir que con una referencia de la clase
		// exception podemos apuntar a cualquier excepción. Esto nos
		// puede servir para agrupar excepciones.
		
		//Vamos a utilizar el código del ejemplo anterior
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
			}catch(Exception e) {
				// si usamos la clase Exception, al ser la clase padre
				// cualquier excepcion que ocurra la controlaremos
				System.out.println("Ha ocurrido algun error");
			}
		}while(!estaCorrecto);

	}

}
