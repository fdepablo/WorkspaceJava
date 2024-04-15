package _10_estaticos;

import java.util.Scanner;

//Si vamos a utilizar un objeto dentro de muchos 
//métodos estaticos, pudemos apoyarnos en un
//atributo estático para poder acceder a el dentro
//de dicho métodos, en vez estar pasandolos por 
//parámetro todo el rato.

//En este ejemplo en vez de pasar el objeto Scanner
//a todos los métodos, vamos a crear un atributo
//estático para poder acceder a el dentro de dichos
//métodos, y así evitar pasar contianmente el objeto
//por parámetro
public class _02_MainEstaticos {
	
	private static Scanner sc;
	
	//private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner scDinamico = new Scanner(System.in);
		int numero = pedirNumeroEntero(scDinamico);
		
		sc = new Scanner(System.in);
		numero = pedirNumeroEnteroEstatico();
	}
	
	public static int pedirNumeroEntero(Scanner sc) {
		System.out.println("Introduce el número entero:");
		int numero = sc.nextInt();
		return numero;
	}
	
	public static int pedirNumeroEnteroEstatico() {
		System.out.println("Introduce el número entero de manera estatica:");
		int numero = sc.nextInt();
		return numero;
	}
	
	public static double pedirNumeroDoubleEstatico() {
		System.out.println("Introduce el número double");
		double numero = sc.nextDouble();
		return numero;
	}
}
