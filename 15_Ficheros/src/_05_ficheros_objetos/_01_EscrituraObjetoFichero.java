package _05_ficheros_objetos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class _01_EscrituraObjetoFichero {
	public static void main(String args[]) {
		// Crear objeto Alumno
		Alumno alu1 = new Alumno("Pedro", 25);
		alu1.calificar("Matemáticas", 50);
		alu1.calificar("Inglés", 75);
		alu1.calificar("Informática", 95);
		alu1.calificar("Lengua", 60);
		
		// Abrir fichero para escritura
		// para escribir objetos a fichero debemos de usar estas clases
		try(FileOutputStream file = new FileOutputStream("alumno.dat");
				ObjectOutputStream escritor = new ObjectOutputStream(file);) {
			escritor.writeObject(alu1);
			System.out.println("El objeto se ha grabado con éxito");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("No se ha podido abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}			
	}
}