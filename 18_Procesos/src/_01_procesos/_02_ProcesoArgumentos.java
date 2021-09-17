package _01_procesos;

import java.io.File;
import java.io.IOException;

public class _02_ProcesoArgumentos {
	public static void main(String[] args) {
		ProcessBuilder proceso;
		// En este caso estamos lanzando el notepad y queremos que habra el archivo
		//"agenda.txt"
		proceso = new ProcessBuilder("C:/Windows/System32/notepad.exe", "agenda.txt");
		//si no existe, te preguntara si quieres crearlo en la carpeta del proyecto
		//Ojo! hay que refrescar el proyecto para verlo
		try {
			//mediante la siguiente linea podemos cambiar la ruta donde queremos guardar el 
			//fichero
			proceso.directory(new File("D:\\"));
			proceso.start().waitFor();
			System.out.println("Proceso lanzado con éxito");
		} catch (IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
