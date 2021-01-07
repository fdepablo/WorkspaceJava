
package _02_ficheros_texto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class _03_LecturaFicheroBuffer {

	public static void main(String[] args) {
		System.out.println("Vamos a leer nuestro fichero de texto " + _01_EscrituraFichero.NOMBRE_FICHERO);
		
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(_01_EscrituraFichero.NOMBRE_FICHERO);
			br = new BufferedReader(fr);
			String frase = br.readLine();//si estamos en EOF, entonces s apuntan a null
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
		} finally {
			try {
				if(br != null)
					br.close();
				if(fr != null)
					fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
