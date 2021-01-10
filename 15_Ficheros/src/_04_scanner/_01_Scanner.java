package _04_scanner;
import java.util.Scanner;

//Tambien podemos usar la clase scanner para leer palabras de un cadana de texto
//Por defecto, leera palabras por espacio en blanco
public class _01_Scanner {
	public static void main(String args[]) {
		String texto = "La cripta mágica";
		Scanner lector = new Scanner(texto);//en vez de System.in usamos una cadena de texto
		while (lector.hasNext()){//entiende que hay otra palabra si hay algo distinto a caracter en blanco
			System.out.println(lector.next());//accedemos a la palabra siguiente
		}
		lector.close();
	}
}