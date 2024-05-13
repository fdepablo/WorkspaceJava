package _03_metodos;

import java.util.Scanner;

public class _02_MetodosYExcepciones {
	public static void main(String[] args) {
		System.out.println("Introduzca un numero");
		int numero = 0;
		try {
			numero = recogerNumeroExcepcion();
		} catch (Exception e) {
			//Este bloque ha sido generado autmáticamente con Eclipse
			//y te invoca automáticamente al método "e.printStackTrace"
			System.out.println("Ha ocurrido un error llamando al método");
		}		
		System.out.println(numero);
	}
	
	//Es posible que ademas de arrojar la excepción queramos capturarla
	//para tratarla en ese momento, y además arrojar hacia arriba
	//En este ejemplo, vamos a capturar la excpción y a arrojarla
	/**
	 * Recoger un número pasado por consola
	 * @return el numero recogido
	 * @throws Exception si el valor introducido no es un número entero
	 */
	public static int recogerNumeroExcepcion() throws Exception{
		Scanner sc = new Scanner(System.in);
		int numero;
		try {
			numero = sc.nextInt();
			return numero;
		} catch (Exception e) {
			System.out.println("Valor incorrecto");
			//Para arrojar un error podemos usar la palabra "throw"
			throw e;
		}finally {
			//Este bloque se ejecuta SIEMPRE sin importar si ha entrado
			//o no por el catch
			System.out.println("Esto siempre se ejecuta haya o no error");
		}	
	}	
}
