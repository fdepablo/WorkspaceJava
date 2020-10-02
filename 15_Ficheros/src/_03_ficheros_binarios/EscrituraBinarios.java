package _03_ficheros_binarios;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class EscrituraBinarios {

	public static void main(String[] args) {
		
		// Creación de 3 objetos producto
		Producto p1 = new Producto("Manzanas Royal Gala",2.50f,7);
		Producto p2 = new Producto("Dátiles de la tía Julita",3.25f,12);
		Producto p3 = new Producto("Mandarinas Clementinas",2.20f,25);
		
		FileOutputStream fichero;
		DataOutputStream  escritor;
		
		// Apertura del fichero almacen.dat
		try {
			//abrimos el fichero en modo add
			fichero = new FileOutputStream("almacen.dat", true);
			escritor = new DataOutputStream (fichero);
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero almacen.dat");
			System.out.println(e.getMessage());
			return;//acabamos con nuestro programa
		}
		
		// Escribir datos en el fichero almacen.dat
		try {
			escritor.writeUTF(p1.getNombre());
			escritor.writeFloat(p1.getPrecio());
			escritor.writeInt(p1.getUnidadesEnExistencia());
					
			escritor.writeUTF(p2.getNombre());
			escritor.writeFloat(p2.getPrecio());
			escritor.writeInt(p2.getUnidadesEnExistencia());
					
			escritor.writeUTF(p3.getNombre());
			escritor.writeFloat(p3.getPrecio());
			escritor.writeInt(p3.getUnidadesEnExistencia());
					
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al escribir datos en el fichero");
			System.out.println(e.getMessage());
		}
		
		try {
			escritor.close();
			fichero.close();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al cerrar el fichero");
			System.out.println(e.getMessage());			
		}
		
		System.out.println("Fin del programa");
	}
}