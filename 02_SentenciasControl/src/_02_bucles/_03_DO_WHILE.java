package _02_bucles;

import java.util.Scanner;

public class _03_DO_WHILE {

	//Existe una variante del bucle "while", que se llama "do-while"
	
	//La filosofía es la misma que la del bucle "While" pero esta vez
	//en vez de ejecutarse entre 0 y N veces, se ejecutará entre
	//1 y N veces. Es decir, al menos el bloque de sentencias se
	//ejecutará UNA vez
	
	public static void main(String[] args) {
		// La sentencia do-while tiene el siguiente formato
		/*
		 * do{
		 * 		//sentencias a ejecutar
		 * }while(EXPRESION_BOOLEAN);
		 */
		
		//Vamos a pedirle un numero al usuario hasta que este entre los valores
		//1 y 10
		int numero = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Introduzca un número entre el 1 y el 10");
			numero = sc.nextInt();
		}while(numero < 1 || numero > 10);
		
		System.out.println("Numero entre 1 y 10");
		
		//Manera similiar, pero avisando al usuario de cuando se ha equivocado
		do {
			System.out.println("Introduzca un número entre el 1 y el 10");
			numero = sc.nextInt();
			if(numero > 10) {
				System.out.println("Te pasaste burt lancaster");
			}
			if(numero < 1) {
				System.out.println("Te quedaste corto");
			}
		}while(numero < 1 || numero > 10);
		
		System.out.println("Numero entre 1 y 10");
	}

}
