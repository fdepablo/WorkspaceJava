package _01_procesos;

import java.io.IOException;

public class _01_Proceso {

	public static void main(String[] args) {
		ProcessBuilder proceso;
		//decimos que el proceso que queremos ejecutar es la calculadora de java
		proceso = new ProcessBuilder("C:/Windows/System32/notepad.exe");
		try {
			//Hasta que no se ejecuta la sentencia proceso.start(), realmente no se lanza el proceso.
			//proceso.start(); //arroja IOException
			//El programa java lanzara la calculadora y finalizara porque no tiene nada más que hacer
			//System.out.println("Proceso lanzado con éxito");
			
			//Si queremos que el programa java se quede esperando a que cerremos la aplicación
			//debemos de utilizar el waitFor()
			//ojo! puede que de problemas segun el programa y la versión del SO, usar
			//"notepad.exe" para este ejemplo
			Process p = proceso.start();
			//waitFor(); devuelve un valor segun la salida del proceso
			int i = p.waitFor();//arroja InterruptedException			
			System.out.println("Valor devuelto de waitFor(): " + i);
			//si se ha cerrado con normalidad devuelve el valor 0
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Programa principal acabado");
	}

}
