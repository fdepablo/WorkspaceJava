package _03_ficheros_binarios;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class LecturaBinarios {

	public static void main(String[] args) {
		FileInputStream fichero;
		DataInputStream  lector;
		
		try {
			fichero = new FileInputStream("almacen.dat");
			lector = new DataInputStream (fichero);
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}
		
		boolean eof = false;
		while (!eof) {
			try {
				String pro = lector.readUTF();//cada vez que leemos algo, es subceptible a que de un EOFException
				float pre = lector.readFloat();
				int uni = lector.readInt();
				Producto p = new Producto(pro, pre, uni);
				System.out.println(p);
			} catch (EOFException e1) {
				eof = true;
			} catch (IOException e2) {
				System.out.println("Ha ocurrido un error al leer los registros");
				System.out.println(e2.getMessage());
				break; // sale del bucle while
			}
		}
		
		try {
			lector.close();
			fichero.close(); 
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al cerrar el fichero");
			System.out.println(e.getMessage());			
		}
	}
	
}