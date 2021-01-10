package _03_ficheros_binarios;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class _03_LecturaBinariosAutoclose {

	public static void main(String[] args) {
		
		//Para leer de un fichero necesitamos los "input"
		try (FileInputStream fichero = new FileInputStream("almacen.dat");
				DataInputStream lector = new DataInputStream (fichero);){
			
			//eof -> end of file, todos los finales de fichero se marcan con eof para saber que 
			//no hay mas datos
			boolean eof = false;
			while (!eof) {
				//cada vez que leemos algo, es subceptible a que de un EOFException
				try {
					String pro = lector.readUTF();
					float pre = lector.readFloat();
					int uni = lector.readInt();
					Producto p = new Producto(pro, pre, uni);
					System.out.println(p);
				} catch (EOFException e1) {
					//si intentamos leer algo y estamos en EOF, entonces dara esta excepcion
					eof = true;
				} catch (IOException e2) {
					System.out.println("Ha ocurrido un error al leer los registros");
					System.out.println(e2.getMessage());
					break; // sale del bucle while
				}
			}
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al abrir el fichero");
			System.out.println(e.getMessage());
			return;
		}		

	}
	
}