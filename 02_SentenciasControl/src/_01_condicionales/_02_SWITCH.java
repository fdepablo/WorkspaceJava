package _01_condicionales;

import java.util.Scanner;

public class _02_SWITCH {
	public static void main(String[] args) {
		//La sentencia SWITCH es equivalente a un "IF-ELSE IF - ELSE"
		//Tiene la siguiente estructura que podemos hacer poniendo
		//"swi" y pulsando "ctrl" + "espacio" y eligiendo "switch case statement"
		
		//Podemos encontrar las siguientes partes
		//Parte switch, entre parentesis ponemos la variable a valorar
		int numero = 5;
		switch (numero) {
		//Podemos tener de 1 a N "case", que serán cada uno de los valores
		//que puede tomar la variable del "switch". 
		case 0:
			System.out.println("El numero es 0");
			break;//Esta palabra reservada hace que dejemos de ejecutar la
				//sentancia "switch" y no entre por otros "case" o por
				//el default
		case 1:
			System.out.println("El número es 1, no es 0");
			break;
		case 2:
			System.out.println("El número es 2, no es ni 0 ni 1");
			break;
		default://Si no cumple ninguno de los casos anteriores, entaria
				//por la sentencia "default"
			System.out.println("El número no es ni 0, ni 1, ni 2");
			break;
		}
		
		
		//Otro ejemplo
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número del 1-7:");		
		numero = sc.nextInt();
		switch (numero) {
		case 1:
			System.out.println("El día es LUNES");
			break;
		case 2:
			System.out.println("El día es MARTES");
			break;
		case 3:
			System.out.println("El día es MIERCOLES");
			break;
		case 4:
			System.out.println("El día es JUEVES");
			break;
		case 5:
			System.out.println("El día es VIERNES");
			break;
		case 6:
			System.out.println("El día es SABADO");
			break;
		case 7:
			System.out.println("El día es DOMINGO :(");
			break;
		default:
			System.out.println("El día introducido no corresponde a un día de la semana");
			break;
		}
		
		//OJO CON NO PONER LOS "break" porque la sentencia se sigue ejecutando
		//aunque no se cumplan los "case"
		System.out.println("Introduzca un número del 1-7:");		
		numero = sc.nextInt();
		switch (numero) {
		case 1:
			System.out.println("El día es LUNES");
		case 2:
			System.out.println("El día es MARTES");
		case 3:
			System.out.println("El día es MIERCOLES");
		case 4:
			System.out.println("El día es JUEVES");
		case 5:
			System.out.println("El día es VIERNES");
		case 6:
			System.out.println("El día es SABADO");
		case 7:
			System.out.println("El día es DOMINGO :(");
		default:
			System.out.println("El día introducido no corresponde a un día de la semana");
		}
		
		//En que casos puede ser interesante no poner el "break"?
		//Normalmente cuando queremos que varios casos se comporten 
		//de la misma manera.
		//En este ejemplo vamos a detecar si el número introducido pertence
		//a un dia "lectivo" o un día de "fin de semana"
		System.out.println("Introduzca un número del 1-7:");		
		numero = sc.nextInt();
		switch (numero) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			//Podemos poner varias sentencias en el "case" para ejecutar
			//sin necesidad de crear "bloques"
			System.out.println("El número introducido es del 1-5");
			System.out.println("El día es LECTIVO");
			break;
		case 6:
		case 7:
			System.out.println("El día es FIN DE SEMANA :)");
			break;
		default:
			System.out.println("El día introducido no corresponde a un día de la semana");
		}
		
		System.out.println("Fin del programa");
	}
}
