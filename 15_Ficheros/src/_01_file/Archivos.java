package _01_file;

import java.io.File;
import java.io.IOException;

public class Archivos {
	public static void main(String[] args) throws IOException {
		//podemos poner rutas absolutas tambien "C:/file.txt" o "C:\\file.txt"
		File fn = new File("file.txt");// Apuntar al fichero definido de manera relativa
		//la clase File sirve para trabajar tanto con ficheros como con directorios
		if (!fn.exists()) {// Averiguamos si existe
			//Creamos el fichero
			fn.createNewFile();
			//Tambien podemos crear un directorio, normalmente le quitamos la 
			//extension al fichero (fn)
			// fn.mkdir();
			System.out.println("Creado archivo " + fn.getName());
		}

		fn.isDirectory();
		fn.isFile();// averiguar si es fichero o directorio
		// lista de ficheros y carpetas si es directorio
		//en caso  de que sea un directorio, podemos listar sus ficheros y sus subdirectorios
		String content[] = fn.list();//podriamos recorrerlo con un for each por ejemplo
		
		fn.canRead();// Averigua si tengo permisos de lectura
		fn.canWrite();// Averiguamos si tenemos permisos de escritura
		fn.lastModified();// fecha de última modificación
		fn.length();// tamaño en bytes
		//fn.delete();// borraria el fichero
	}
}
