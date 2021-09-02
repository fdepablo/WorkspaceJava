
import java.util.Scanner;

//Problema con la clase Scanner
//https://puntocomnoesunlenguaje.blogspot.com/2012/08/java-scanner.html
public class _04_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dime tu nombre:");
		String nombre = sc.nextLine();
		System.out.println("Hola " + nombre + ", bienvenido");
		
		System.out.println("Dime tu edad:");
		int edad = sc.nextInt();
		System.out.println("Tu edad es: " + edad);
		sc.close();
	}
}
