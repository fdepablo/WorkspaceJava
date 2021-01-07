package _01_file;

import java.io.File;
import java.io.IOException;

/*
 Con la clase File podemos trabajar tanto con ficheros como con directorios
 */
public class ClaseFile {
	public static void main(String[] args) throws IOException {
		//podemos poner rutas absolutas tambien "C:/file.txt" o "C:\\file.txt"
		File fn = new File("file.txt");// Apuntar al fichero definido de manera relativa
		if (!fn.exists()) {// Averiguamos si existe
			//Creamos el fichero
			fn.createNewFile();
			//Tambien podemos crear un directorio, normalmente le quitamos la 
			//extension al fichero (fn)
			// fn.mkdir();
			System.out.println("Creado el archivo " + fn.getName());
		}

		System.out.println(fn.isDirectory());
		System.out.println(fn.isFile());// averiguar si es fichero o directorio
		// lista de ficheros y carpetas si es directorio
		//en caso  de que sea un directorio, podemos listar sus ficheros y sus subdirectorios
		String content[] = fn.list();//podriamos recorrerlo con un for each por ejemplo
		
		System.out.println(fn.canRead());// Averigua si tengo permisos de lectura
		System.out.println(fn.canWrite());// Averiguamos si tenemos permisos de escritura
		System.out.println(fn.lastModified());// fecha de última modificación
					//nos devuelve el numero de milisegundos desde 1970 (fecha unix)
		System.out.println(fn.length());// tamaño en bytes
		fn.delete();// borraria el fichero
	}
}
