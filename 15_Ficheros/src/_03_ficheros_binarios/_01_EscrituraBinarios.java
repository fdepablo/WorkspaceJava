package _03_ficheros_binarios;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class _01_EscrituraBinarios {

	public static void main(String[] args) {
		
		// Creación de 3 objetos producto
		Producto p1 = new Producto("Manzanas Royal Gala",2.50f,7);
		Producto p2 = new Producto("Dátiles de la tía Julita",3.25f,12);
		Producto p3 = new Producto("Mandarinas Clementinas",2.20f,25);
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		
		//Para trabajar con ficheros binarios podemos usar las dos siguientes clases
		FileOutputStream fichero;
		DataOutputStream  escritor;
		
		// Apertura del fichero almacen.dat
		try {
			//abrimos el fichero en modo add (true)
			fichero = new FileOutputStream("almacen.dat", true);
			escritor = new DataOutputStream (fichero);
		} catch (IOException e) {
			System.out.println("No se ha podido abrir el fichero almacen.dat");
			System.out.println(e.getMessage());
			return;//acabamos con nuestro programa
		}
		
		// Escribir datos en el fichero almacen.dat
		try {
			for(Producto p : listaProductos) {
				//Es interesante usar el metodo adecuado al tipo de dato que queremos guardar
				escritor.writeUTF(p.getNombre());//escribimos en UTF-8
				escritor.writeFloat(p.getPrecio());
				escritor.writeInt(p.getUnidadesEnExistencia());
			}					
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al escribir datos en el fichero");
			System.out.println(e.getMessage());
		}
		
		//simpre cerramos los canales de comunicacion
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