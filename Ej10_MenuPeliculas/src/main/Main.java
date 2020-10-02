package main;

import java.util.ArrayList;
import java.util.Scanner;

import entidades.*;
import negocio.GestorPeliculas;

public class Main {
	
	Scanner sc = new Scanner(System.in);
	static GestorPeliculas ge = new GestorPeliculas();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		int opcion = 0;
		do{
			opcion = main.mostrarMenu();
			switch (opcion) {
			case 1://alta
				Pelicula pelicula = main.crearPelicula();
				ge.alta(pelicula);
				break;
	
			case 2://baja
				String sId = main.pedirId();
				int iId = Integer.parseInt(sId);
				ge.baja(iId);
				break;
			
			case 3://listar
				ArrayList<Pelicula >listaPeliculas = ge.getListaEmpleados();
				main.mostrarListaPeliculas(listaPeliculas);
				break;
			}
		}while(main.continuar(opcion));
		
		System.out.println("Fin del programa");
	}

	private boolean continuar(int opcion) {
		// TODO Auto-generated method stub
		if(opcion == 4)
			return false;
		else
			return true;
	}


	private void mostrarListaPeliculas(ArrayList<Pelicula> listaPelicula) {
		for(Pelicula pelicula : listaPelicula){
			System.out.println(pelicula);
		}
	}

	/**
	 * Metodo que pide un nombre al usuario para borrar
	 * @return String con el nombre a borrar
	 */
	private String pedirId() {
		System.out.println("Introduzca el id de la pelicula a borrar");
		String id = sc.next();
		return id;
	}

	/**
	 * Metodo que crea un empleado a partir de los datos
	 * introducidos por pantalla del usuario
	 * @return El empleado creado que puede ser Trabajador,Jefe,Director
	 */
	private Pelicula crearPelicula() {
		//al usar un sc.nextInt y luego un sc.nextLine da problemas
		//por lo que limpiamos el buffer del scanner
		sc.nextLine();
		
		System.out.println("Introduzca el titulo:");
		String titulo = sc.nextLine();
		System.out.println("Introduzca el genero:");
		String genero = sc.nextLine();
		System.out.println("Introduzca los actores:");
		
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo(titulo);
		pelicula.setGenero(genero);
		
		ArrayList<Actor> listaActores = new ArrayList<>();
		String continuar = null;
		do{
			System.out.println("Introduzca el nombre:");
			String nombreActor = sc.nextLine();
			System.out.println("Introduzca la edad:");
			int edadActor = sc.nextInt();
			Actor actor = new Actor();
			actor.setNombre(nombreActor);
			actor.setEdad(edadActor);
			listaActores.add(actor);
			System.out.println("Desea introducir mas?(S/N):");
			continuar = sc.next();
			sc.nextLine();
		}while(continuar.equalsIgnoreCase("S"));

		pelicula.setListaActores(listaActores);
		
		return pelicula;
	}

	private int mostrarMenu() {
		System.out.println("Introduzca la opcion que quiere realizar");
		System.out.println("1 - Alta pelicula");
		System.out.println("2 - Baja pelicula");
		System.out.println("3 - Listar peliculas");
		System.out.println("4 - Salir del programa");
		int opcion = sc.nextInt();
		return opcion;
	}
}
