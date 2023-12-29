package clases_nativas;

import java.util.Date;

public class _04_Date {
	public static void main(String[] args) {
		//La manera más básica de trabajar con fechas en java es con la clase
		//Date
		
		//La clase Date toma como referencia de la hora la del sistema operativo
		//Cuando instanciamos la clase Date obtendremos la hora del sistema
		//donde estemos ejecutando el programa
		
		//OJO, la clase Date que normalmente usaremos sera la del paquete
		//java.util
		Date fecha = new Date();//
		System.out.println(fecha);
		
		//Internamente la clase Date lo que guarda es el número
		//de milisegundos que han pasado desde el 01/01/1970 00:00:00
		//tambien llamada hora UNIX. Se guarda en una variable de tipo
		//long
		//Podemos acceder a ella
		System.out.println(fecha.getTime());
		
		//Si queremos manejar fechas debemos de basarnos en otras clases
		//la clase Date tiene casi todos sus metodos OBSOLETOS (deprecated)
		//Los métodos obsoletos se mantienen para hacer retrocompatibilidad
		//entre versiones superiores de java frente a las inferiores, pero
		//nos dicen que hay otras maneras mejores de hacer la funcionalidad
		System.out.println(fecha.getDay());//los dias van del 0 al 6
		System.out.println(fecha.getMonth());//los meses van del 0 al 11
		System.out.println(fecha.getYear());//Es el año actual menos 1900
		
		//Hay una manera más facil de obtener el número de milisegundos
		System.out.println(System.currentTimeMillis());
		
		//Podemos medir tiempos restando fechas
		long tiempo = System.currentTimeMillis() - fecha.getTime();
		
		System.out.println("Tiempo total de ejecucción del programa: " + tiempo);
	}
}
