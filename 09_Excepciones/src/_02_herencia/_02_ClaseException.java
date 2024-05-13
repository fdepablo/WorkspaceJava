package _02_herencia;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _02_ClaseException {

	public static void main(String[] args) {
		//Vamos a utilizar el código del ejemplo anterior
		//pero esta vez vamos a controlar las especificas
		//y las genericas
		
		//Esta puede ser una buena práctica de programación
		//capturar las excepciones que conozcas y luego
		//tener un bloque "catch" generico para capturar
		//las que no conozcas
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
			}catch(Exception e) {
				// si usamos la clase Exception, al ser la clase padre
				// cualquier excepcion que ocurra la controlaremos
				System.out.println("Ha ocurrido algun error");
			}
		}while(!estaCorrecto);

	}

}
