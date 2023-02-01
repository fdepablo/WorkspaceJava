package vista;

import java.util.Scanner;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersona;

public class MainTresCapas {

	public static void main(String[] args) {
		
		System.out.println("Bienvenidos a nuestra CRUD de personas");
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		GestorPersona gp = new GestorPersona();
		
		do {
			menu();
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Introduzca los datos del usuario (nombre/edad/peso)");
				String nombre = sc.next();
				int edad = sc.nextInt();
				double peso = sc.nextDouble();
				
				Persona p = new Persona();
				p.setNombre(nombre);
				p.setEdad(edad);
				p.setPeso(peso);
				
				int alta = gp.alta(p);
				if(alta == 0) {
					System.out.println("Persona dada de alta");
				}else if(alta == 1) {
					System.out.println("Error de conexión con la BBDD");
				}else if(alta == 2){
					System.out.println("El usuario tiene menos de tres carateres");
				}
				break;

			case 0:
				fin = true;
				break;
			}
		}while(!fin);
		
		System.out.println("Fin de programa");

	}

	private static void menu() {
		System.out.println("Elija una opci�n:");
		System.out.println("1- Alta de persona");
		System.out.println("0- Salir del programa");
	}

}
