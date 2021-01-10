package _05_ficheros_objetos;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class _02_LecturaObjetoFichero {
	public static void main(String args[]) throws ClassNotFoundException {
		// Abrir el fichero
		// Lee el objeto guardado en el archivo alumno.dat
		try (FileInputStream file = new FileInputStream("alumno.dat");
				ObjectInputStream escritor = new ObjectInputStream(file);){
			
			Alumno alu1 = (Alumno) escritor.readObject();//importante castearlo, ya que read objet
														//devuelve una referencia de tipo Object
			System.out.println("Nombre del alumno: " + alu1.getNombre());
			System.out.println("Edad: " + alu1.getEdad());
			for (Calificacion c : alu1.getCalificaciones()) {
				System.out.println(c);
			}
		} catch (IOException e) {
			System.out.println("Error al leer en el fichero");
			e.printStackTrace();
		}
	}
}