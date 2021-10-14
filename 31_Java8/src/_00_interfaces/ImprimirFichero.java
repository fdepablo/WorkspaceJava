package _00_interfaces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImprimirFichero implements Imprimir{

	private String nombreFichero;
	
	public ImprimirFichero(String fichero) {
		this.nombreFichero = fichero;
	}
	
	@Override
	public void imprimir(String cadena) {
		File fichero = new File(nombreFichero);
		
		//try-with-resoruce
		//Esta sentencia lo que hace es invocar el .close() de los objetos
		//que esten dentro de los parentesis de manera automática al salir
		//del bloque try-catch
		//Esto esta desde la version 1.7 de Java
		try (FileWriter fw = new FileWriter(fichero)){			
			fw.write(cadena);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //un fw.close() de manera implicita
	}

	@Override
	public String getNombreImpresion() {
		return "Imprimir por fichero";
	}
	
	public String getNombreFichero() {
		return nombreFichero;
	}

}
