package _03_ficheros_binarios;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Exacatmente igual que el ejemplo 01, pero con try/catch autoclose
public class _02_EscrituraBinariosAutoclose {

	public static void main(String[] args) {
		
		// Creación de 3 objetos producto
		Producto p1 = new Producto("Manzanas Royal Gala",2.50f,7);
		Producto p2 = new Producto("Dátiles de la tía Julita",3.25f,12);
		Producto p3 = new Producto("Mandarinas Clementinas",2.20f,25);
		
		List<Producto> listaProductos = new ArrayList<Producto>();
		listaProductos.add(p1);
		listaProductos.add(p2);
		listaProductos.add(p3);
		
		// Apertura del fichero almacen.dat
		try(FileOutputStream fichero = new FileOutputStream("almacen.dat", true);
				DataOutputStream  escritor = new DataOutputStream (fichero);) {
			
			for(Producto p : listaProductos) {
				escritor.writeUTF(p.getNombre());
				escritor.writeFloat(p.getPrecio());
				escritor.writeInt(p.getUnidadesEnExistencia());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return;//acabamos con nuestro programa
		}
			
		System.out.println("Fin del programa");
	}
}