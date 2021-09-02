package presentacion;

import java.util.Scanner;

import beans.Persona;
import negocio.GestorPersonas;

/**
 * Programa que de alta usuarios en memoria y los lista
 * mostrando un menu con las opciones posibles. No se adminte 
 * nombres de mas de 10 carateres
 * @author Jorge Rodriguez
 *
 */
public class Main {

	/**
	 * Funcion de entrada
	 * @param args los argumentos de entrada de la aplicacion
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		GestorPersonas gp = new GestorPersonas();
		String opcion = "-1";
		System.out.println(" ** Bienvenidos a nuestra aplicacion");
		do {
			System.out.println(" ** Elija una opcion del menu **");
			System.out.println(" 1- Alta de una persona");
			System.out.println(" 2- Listar personas");
			System.out.println(" 0- Salir del programa");
			opcion = sc.nextLine();
			if(opcion.equals("1")) {
				System.out.println("Introduzca el nombre de la persona");
				String nombre = sc.nextLine();
				Persona p = new Persona();
				p.setNombre(nombre);
				int resultado = gp.altaPersona(p);
				if (resultado == 2) {
					System.out.println("El numero maximo de caractes para el nombre es de 10");
				} else if (resultado == 1) {
					System.out.println("La capacidad esta llena");
				} else {
					System.out.println("Usuario introducido correctamente");
				} 
			}else if(opcion.equals("2")) {
				Persona[] personas = gp.listarPersona();
				for(Persona p : personas) {
					//solo mostramos cuando p no apunte a null
					if(p != null) System.out.println(p);
				}
			}
			
		} while (!opcion.equals("0"));
		
		System.out.println(" *** Gracias por utilizar nuestra aplicacion ***");
		sc.close();
	}
	
}
