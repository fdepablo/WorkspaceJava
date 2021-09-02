package _01_excepciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main6 {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean continuar = false;
		do {
			try {
				int numero = pedirValor("Numerador");
				System.out.println("numero :" + numero);
				continuar = false;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continuar = true;
				System.out.println("------------- e.getMessage() --------------");
				//Devuelve una descripción de la excepción. Devuelve null
				//porque el que creo la excepcion no le puso ningun valor
				System.out.println(e.getMessage());
				System.out.println("------------- e.getLocalizedMessage() --------------");
				//ver el ejemplo de 02_personalizadas para más detalles
				System.out.println(e.getLocalizedMessage());
				System.out.println("------------- e.getToString() --------------");
				System.out.println(e);//cuando se imprime un objeto se llama automaticamente a toString()
				System.out.println("------------- e.printStackTrace --------------");
				//Muestra el flujo de error estándar.
				e.printStackTrace();
				System.out.println("------------- e.printStackTrace(Fichero) --------------");
				try {
					//Muestra el flujo de error estándar por un fichero que queramos
					//PrintStream arroja excepciones checked
					e.printStackTrace(new PrintStream(new File("ficheroError.txt")));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("------------- e.printStackTrace(Fichero) --------------");
			}
		} while (continuar);
	}

	// si la excepcion arrojada es de tipo exception, entonces
	// tenemos que capturarla
	public static int pedirValor(String tipo) throws Exception {

		int numero = 0;
		try {
			
			System.out.println("Introduzca el " + tipo);
			numero = sc.nextInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//si en vez de arrojarla directametne creamos una nueva con un mensaje
			//si apareceria en el getMessage()
			throw e;
		}

		return numero;
	}
}
