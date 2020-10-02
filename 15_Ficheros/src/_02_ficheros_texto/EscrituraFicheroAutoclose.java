
package _02_ficheros_texto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscrituraFicheroAutoclose {

	public static final String NOMBRE_FICHERO = "prueba.txt";
	
	public static void main(String[] args) {
		System.out.println("Escritura de fichero " + NOMBRE_FICHERO);

		//Desde la 1.7 podemos hacer que los recursos se autocierren
		//siempre y cuando dicho recurso implemente la interfaz
		//java.lang.AutoCloseable
		//esto ayuda a mantener el codigo más compacto y entendible
		//los recursos van entre parentesis despues del bloque try
		//si tenemos varios, podemos separararlos por ';'
		try(FileWriter fw = new FileWriter(NOMBRE_FICHERO);
				PrintWriter pw = new PrintWriter(fw);) {
			//Si ponemos (nombreFichero,true) add en vez de borrar
			pw.println("Esto es una prueba de escritura en el fichero");
			pw.println("Aqui podemos escribir lo que queramos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//ya no hace falta cerrar los recursos ya que se cerraran automaticamente

		System.out.println("Fichero creado y rellenado");
	}
}
