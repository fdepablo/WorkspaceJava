package _01_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

//mismo ejemplo pero de manera diferente, para capturar el nominador y el denominador
//por separado
public class Main2 {
	public static void main(String[] args) {
		boolean continuar = false;
		Scanner sc = new Scanner(System.in);
		
		int numerador = 0;
		do{
			try{				
				System.out.println("Introduzca dos numero a dividir");
				System.out.println("Introduzca el numerador");
				numerador = sc.nextInt();
				continuar = false;
			}catch(ArithmeticException ae){
				System.out.println("No se puede dividir por cero");
				continuar = true;
			}catch(InputMismatchException ime){
				System.out.println("Solo se adminten numeros");
				continuar = true;
			}catch(Exception e){
				System.out.println("Algun tipo de error ocurrido");
				continuar = true;
			}
		}while(continuar);
		
		continuar = false;
		do{
			try{
				System.out.println("Introduzca el denominador");
				int denominador = sc.nextInt();
				int resultado = numerador/denominador;
				System.out.println("El resultado es: " + resultado);
			}catch(ArithmeticException ae){
				System.out.println("No se puede dividir por cero");
				continuar = true;
			}catch(InputMismatchException ime){
				System.out.println("Solo se adminten numeros");
				continuar = true;
			}catch(Exception e){
				System.out.println("Algun tipo de error ocurrido");
				continuar = true;
			}
		}while(continuar);
		
		System.out.println("Programa terminado");
		sc.close();
	}
}
