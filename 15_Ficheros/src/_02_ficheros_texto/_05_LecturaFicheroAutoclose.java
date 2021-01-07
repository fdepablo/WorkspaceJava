
package _02_ficheros_texto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _05_LecturaFicheroAutoclose {

	public static void main(String[] args) {
		System.out.println("Vamos a leer nuestro fichero de texto + " + _04_EscrituraFicheroAutoclose.NOMBRE_FICHERO);

		try (FileReader fr = new FileReader(_04_EscrituraFicheroAutoclose.NOMBRE_FICHERO);
			 BufferedReader br = new BufferedReader(fr);) {
			String frase = br.readLine();
			while(frase != null){
				System.out.println("Frase del fichero: " + frase);
				frase = br.readLine();
			}
			System.out.println("Fichero leido correctamente");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
