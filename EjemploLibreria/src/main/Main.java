package main;

import java.util.List;
import java.util.Scanner;

import entidades.Autor;
import entidades.Libro;
import negocio.GestorAutores;
import negocio.GestorLibros;

public class Main {

	Scanner sc = new Scanner(System.in);
	static GestorAutores ga = new GestorAutores();
	static GestorLibros gl = new GestorLibros();
	
	public static void main(String[] args) {
		
		Main main = new Main();
		ga.cargarListaAutores();
		int opcion = 0;
		Libro libro = null;
		do{
			opcion = main.mostrarMenu();
			switch (opcion) {
			case 1://alta
				libro = main.crearLibro();
				gl.alta(libro);
				break;
	
			case 2://baja
				libro = main.pedirLibro();
				gl.baja(libro);
				break;
			
			case 3://listar
				main.mostrarListaLibros(gl.getListaLibros());
				break;
			case 4://mostra salario
				String titulo = main.pedirString("titulo");
				libro = gl.buscarPorTitulo(titulo);
				System.out.println(libro);
				break;		
			case 5:
				Autor autor = main.escogerAutor(true);
				List<Libro> listaLibrosAutor = gl.buscarPorAutor(autor);
				main.mostrarListaLibros(listaLibrosAutor);
				break;	
			case 6:
				List<Libro> listaLibrosOrdenados = gl.ordenarLibros();
				main.mostrarListaLibros(listaLibrosOrdenados);
			}
		}while(main.continuar(opcion));
		
		System.out.println("Fin del programa");
	}

	private String pedirString(String cadena) {
		sc.nextLine();
		System.out.println("Introduzca el " + cadena + " a buscar");
		String valor = sc.nextLine();
		return valor;
	}

	private Libro pedirLibro() {
		System.out.println("Escoja un libro de la lista");
		int i = 0;
		for(Libro libro : gl.getListaLibros()){
			System.out.println(i++ + "-" + libro);
		}
		int opcion = sc.nextInt();
		Libro libro = gl.getListaLibros().get(opcion);
		return libro;
	}

	private boolean continuar(int opcion) {
		// TODO Auto-generated method stub
		if(opcion == 7)
			return false;
		else
			return true;
	}

	private void mostrarListaLibros(List<Libro> listaLibros) {
		for(Libro libro : listaLibros){
			System.out.println(libro);
		}
	}

	private Libro crearLibro() {
		sc.nextLine();
		System.out.println("Introduzca el titulo:");
		String titulo = sc.nextLine();
		System.out.println("Introduzca isbn:");
		String isbn = sc.nextLine();
		Autor autor = escogerAutor(false);
		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setIsbn(isbn);
		libro.setAutor(autor);
		
		return libro;
	}

	private Autor escogerAutor(boolean doNextLine) {
		if(doNextLine){
			sc.nextLine();
		}
		System.out.println("Escoja un autor de la lista");
		int i = 0;
		for(Autor autor : ga.getListaAutores()){
			System.out.println(i++ + "-" + autor);
		}
		int opcion = sc.nextInt();
		Autor autor = ga.getListaAutores().get(opcion);
		return autor;
	}

	private int mostrarMenu() {
		System.out.println("Introduzca la opcion que quiere realizar");
		System.out.println("1 - Alta libro");
		System.out.println("2 - Baja libro");
		System.out.println("3 - Listar libros");
		System.out.println("4 - Buscar libro por titulo");
		System.out.println("5 - Bucar libro por autor");
		System.out.println("6 - Ordenar libros");
		System.out.println("7 - Salir de cañas");
		int opcion = sc.nextInt();
		return opcion;
	}
}
