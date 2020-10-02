package _05_ficheros_objetos;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class LecturaVariosObjetosAvailable {
	public static void main(String args[]) throws IOException  {
		int bytesEnBuffer;
		
		// Abrimos fichero agenda.dat para lectura
		FileInputStream file;
		ObjectInputStream buffer;
		try {
			file = new FileInputStream("agenda.dat");
			buffer = new ObjectInputStream(file);
			bytesEnBuffer = file.available();
		} catch (IOException e) {
			System.out.println("No se ha podido abrir la agenda de contactos");
			System.out.println(e.getMessage());
			return;
		}	
		
		// Leemos la lista de contactos
		//preguntamos si hay más contenido disponible
		//este metodo nos devuelve el numero de bytes que quedan por leer
		System.out.println("Bytes por leer: " + bytesEnBuffer);
		Contacto c;
		while (bytesEnBuffer > 0) {//mientras haya bytes que leer, sigo leyendo objetos
			try {
				c = (Contacto) buffer.readObject();//leemos
				System.out.println(c);
			} catch (IOException e2) {
				System.out.println("Error al leer los contactos de la agenda");
				System.out.println(e2.getMessage());
			} catch (ClassNotFoundException e3) {
				System.out.println("La clase Contacto no está cargada en memoria");
				System.out.println(e3.getMessage());
			}
			bytesEnBuffer = file.available();//preguntamos si hay más contenido disponible
										//este metodo nos devuelve el numero de bytes que quedan por leer
			System.out.println("Bytes pendientes en buffer: " + bytesEnBuffer);
		}
	
		// Cerramos el fichero
		// no os olvideis de cerrar siempre las conexiones
		try {
			buffer.close();
			file.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el fichero");
			System.out.println(e.getMessage());
		}
		
	}
}