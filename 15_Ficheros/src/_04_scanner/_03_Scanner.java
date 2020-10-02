package _04_scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _03_Scanner {
	public static void main(String args[]) throws FileNotFoundException {
		File fichero = new File("peliculas.txt");
		if (!fichero.exists()) { // Si no existe el fichero
			System.out.println("El fichero no existe");
			return;
		}
		
		Scanner lector = new Scanner(fichero);
		while (lector.hasNext()) {
			String linea = lector.nextLine();
			System.out.println(linea);
		}
		
		lector.close();
	}
}