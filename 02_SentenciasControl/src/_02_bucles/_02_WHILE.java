package _02_bucles;

import java.util.Scanner;

public class _02_WHILE {

	//Los bucles "for" están pensados principalmente para realizar
	//un número determinado de saltos. Ej: 1 a 30, de 30 a 1, etc
	
	//Tenemos otro tipo de bucles que están pensados para hacer un 
	//número indeterminado de saltos, es decir, que no estamos
	//muy seguros del número de iteraciones que vamos a realizar.
	
	//Para este tipo de bucles utilizaremos el llamado bucle "while"
	//Este tipo de bucle es una "mezcla" entre un "for" y un "if"
	
	//Para utilzar este tipo de bucle usaremos la siguiente sentencia:
	//while(EXPRESION_BOOLEAN)
	
	//El "while" se ejecutará siempre y cuando la expresión boolean de
	//dentro de los paréntesis sea "true"
	
	//OJO, en este tipo de bucles es muuuucho más facil hacer bucles
	//infinitos
	
	public static void main(String[] args) {
		//El ejemplo más facil sería un bucle infinito
		/*
		while(true)
			System.out.println("Esto es un bucle infinito");
		*/
		
		//Normalmente podemos siempre bloque dentro del while
		//y debemos de concluir el bucle en algún momento
		
		//Imprimir los 10 primeros números mediante un bucle while
		int numero = 1;
		while(numero <=10) {
			System.out.println(numero++);
		}
		
		//Todo algoritmo tiene su equivalente de "for" a "while" 
		//(incluso a la inversa, aunque no sea lo habitual)
		
		//La filosofia de un bucle "while" es ejecutar una serie
		//de sentencias entre 0 y N veces, es decir, que si 
		//no cumple la condición ni una sola vez, no entraría en el bucle
		
		numero = 11;
		while(numero <=10) {
			System.out.println("Esto no se ejecutaria ninguna vez");
		}
		
		//Lo más habitual es usar un "while" cuando no sabemos el número de
		//iteraciones que vamos a realizar
		
		//Vamos a pedirle un numero al usuario hasta que este entre los valores
		//1 y 10
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número entre el 1 y el 10, pls :)");
		numero = sc.nextInt();
		while(numero < 1 || numero > 10) {
			System.out.println("El numero es incorrecto");
			System.out.println("Introduzca un número entre el 1 y el 10, pls :)");
			numero = sc.nextInt();
		}
		System.out.println("El numero esta entre 1 y 10");
		
		//Manera equivalente con una variable booleana que hace efecto de "flag"
		boolean correcto = false;//Esta variable hace efecto de "flag" o "bandera"
								//es decir, va a hacer que se sigua ejecutando
								//el bucle "while" o no.
								//En este caso parto de la base en que el usuario
								//va a introducir mal los datos, por lo tanto
								//establezco correcto=false
		while(!correcto) {
			System.out.println("Introduzca un número entre el 1 y el 10, pls :)");
			numero = sc.nextInt();
			if(numero <= 10 && numero >= 1) {
				System.out.println("El numero esta entre 1 y 10");
				correcto = true;
			}else {
				System.out.println("El numero es incorrecto");
			}			
		}
		
	}
}
