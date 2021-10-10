
package _02_ficheros_texto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class _04_EscrituraFicheroAutoclose {

	public static final String NOMBRE_FICHERO = "prueba.txt";
	
	public static void main(String[] args) {
		System.out.println("Escritura de fichero " + NOMBRE_FICHERO);

		//Desde la 1.7 podemos hacer que los recursos se autocierren siempre y cuando 
		//dicho recurso implemente la interfaz java.lang.AutoCloseable
		//Se llaman try-with-resources statement
		
		//El recurso se cerrará como si lo hubieramos puesto en la clausula "finally"
		//esto ayuda a mantener el codigo más compacto y entendible.
		//Los recursos van entre parentesis despues del bloque try
		//si tenemos varios, podemos separararlos por ';'
		try(FileWriter fw = new FileWriter(NOMBRE_FICHERO);
				BufferedWriter pw = new BufferedWriter(fw);) {
			//Si ponemos (nombreFichero,true) add en vez de borrar
			pw.write("Esto es una prueba de escritura en el fichero");
			pw.newLine();
			pw.write("Aqui podemos escribir lo que queramos");
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//ya no hace falta cerrar los recursos ya que se cerraran automaticamente

		System.out.println("Fichero creado y rellenado");
	}
}
