package _01_basico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _01_IntroduccionExcepciones {

	/*
	 * Las excepciones en java son situaciones que pueden provocar un fallo
	 * en el programa.
	 * 
	 * Cuando se lanza una excepción en Java y no se controla, se para
	 * automáticamente el programa
	 */
	public static void main(String[] args) {
		String s = null;
		//s.charAt(0);//Excepción, concretamente NullPointerException

		//La opción que tenemos en java para controlar excepciones es mediante los
		//llamado bloques "try-catch"
		
		//En la parte "try" ponemos el código el cual queremos capturar posibles
		//Excepciones
		//En la parte "catch" ponemos el código que queremos ejecutar en caso de
		//que ocurra alguan excepción, y por lo tanto NO se parará el programa.
		//Es obligatorio poner en la parte "catch" el tipo de excepción que queremos
		//capturar
		
		//El programa continuará con su ejecución de manera normal cuando salga
		//del bloque "try-catch"
		
		try {
			s.charAt(0);
		}catch(NullPointerException npe) {
			//Aquí ejecutamos las sentencias que queramos
			System.out.println("OJO! que te cojo! s está apuntado a NULL (munion)");
		}
		
		System.out.println("Contiunamos con la ejecución del programa");
		
		//OJO!!! Esto NO arregla el problema, esto lo único que hace es evitar
		//que el programa se pare
		
		//Este código de aquí si el usuario introduce "trece", el programa
		//se parará, porque ocurre la expción "java.util.InputMismatchException"
		//Y como se para el programa, no puedo decirle al usuario que lo ha
		//hecho mal
		/*
		System.out.println("Introduzca un número:");
		Scanner sc = new Scanner(System.in);
		Integer n1 = sc.nextInt();
		System.out.println("El número introducido es: " + n1);
		*/
		
		//Usamos un bloque "try-catch" para evitar que el programa se pare
		/*
		try {
			System.out.println("Introduzca un número:");
			Scanner sc = new Scanner(System.in);
			Integer n1 = sc.nextInt();
			System.out.println("El número introducido es: " + n1);
		}catch(InputMismatchException ime) {
			System.out.println("Eres un muñon, el valor debe de ser numérico!!");
		}*/
		//OJO! Esto no arregla el programa!! Pero al menos me da la opción de intentar
		//arreglarlo
		boolean numeroCorrecto = false;
		do {
			
			try {
				System.out.println("Introduzca un número:");
				Scanner sc = new Scanner(System.in);
				Integer n1 = sc.nextInt();//Aquí se lanzaría la excecpion
				System.out.println("El número introducido es: " + n1);
				//Si llegamos a esta linea, no hubo una excepción
				numeroCorrecto = true;
			}catch(InputMismatchException ime) {
				System.out.println("Eres un muñon, el valor debe de ser numérico!!");
			}
		}while(!numeroCorrecto);
		
		//En esta última parte hemos usado los bloques "try-catch" para ayudarnos
		//a controlar la excepciones y poder aplicar lógica para solucinarlo.
		
		//Muchas veces podremos controlar las expcepciones con "if", lo que suele
		//ser a nivel de código más óptimo
		String s2 = null;
		if(s2 != null) {
			s2.charAt(0);
		}

	}

}
