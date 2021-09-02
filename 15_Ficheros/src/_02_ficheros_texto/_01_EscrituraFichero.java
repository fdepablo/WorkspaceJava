
package _02_ficheros_texto;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class _01_EscrituraFichero {

	public static final String NOMBRE_FICHERO = "prueba.txt";
	
	public static void main(String[] args) {
		System.out.println("Escritura de fichero " + NOMBRE_FICHERO);
		
		FileWriter fw = null;
		PrintWriter pw = null;
		//Las lecturas y escrituras de los ficheros normalmente arrojan excepciones "checked"
		//por lo que tenemos que capturarlas o el programa no compilará
		try {
			//Abrimos el fichero en modo escritura, cada vez que lo abrimos se borra lo anterior
			fw = new FileWriter(NOMBRE_FICHERO);//Si ponemos (nombreFichero,true) add en vez de borrar
			//fw = new FileWriter(new File(NOMBRE_FICHERO));//equivalente
			pw = new PrintWriter(fw);
			pw.println("Esto es una prueba de escritura en el fichero");
			pw.println("Aqui podemos escribir lo que queramos");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//siempre debemos de cerrar el fichero despues de usarlo
			if(fw != null && pw != null){
				pw.close();
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Fichero creado y rellenado");
	}

	
}
