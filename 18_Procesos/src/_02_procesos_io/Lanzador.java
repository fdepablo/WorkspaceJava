package _02_procesos_io;

import java.io.File;
import java.io.IOException;

//Esta clase se va a encargar de ejecutar la clase "Principal"
public class Lanzador {
	public static void main(String[] args) {
		ProcessBuilder proceso;
		//Con esto decimos que vamos a arrancar el proceso Java y como primer
		//argumento le pasamos Principal, es decir ejecutamos la clase "Principal"
		//ponemos el nombre del paquete tambien
		proceso = new ProcessBuilder("java", "_07_procesos_io/Principal");
		//al ser un proceso que lanzamos no vamos a tener las tipicas entradas y salidas
		//del usuario (consola)
		//Con estas tres lineas le decimos al proceso que los errores los guarde en "errores.txt",
		//que la salida la guarde en "salida.txt" y que los parametros de entrada los recoja
		//de "entrada.txt", respectivamente. El archivo "entrada.txt" debe de existir antes de 
		//ejecutar el programa
		proceso.redirectError(new File("errores.txt"));//System.err
		proceso.redirectOutput(new File("salida.txt"));//System.out
		proceso.redirectInput(new File("entrada.txt"));//System.in

        try {
			proceso.start();
			System.out.println("El proceso ha sido lanzado con éxito");
			System.out.println("Examina los archivos errores.txt y salida.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
