package _02_ficheros_texto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFicheroBuffer {
	public static void main(String args[]) {

		// Abrir fichero para escritura
		FileWriter file;
		try {
			file = new FileWriter("peliculas.txt");
		} catch (IOException e) {
			System.out.println("No se puede abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}

		// Abrir buffer y escribir tres líneas
		BufferedWriter buffer = new BufferedWriter(file);
		try {
			buffer.write("¡Bienvenido, Mister Marshall!");
			buffer.newLine();
			buffer.write("Con la muerte en los talones");
			buffer.newLine();
			buffer.write("Muerte de un ciclista");
			buffer.newLine();
		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero");
			System.out.println(e.getMessage());
		}

		// Cerrar el buffer y el fichero
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
			System.out.println(e.getMessage());
		}

		System.out.println("Fin del programa");
	}
}
