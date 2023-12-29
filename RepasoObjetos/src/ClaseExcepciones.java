import java.util.InputMismatchException;
import java.util.Scanner;

public class ClaseExcepciones {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//Throable -> Exeception -> RuntimeExepciont
		
		//Si la clase extiende de Exception entonces la excepciones checkeado
		//Si la clase extiende de RuntimeExcepction entonces la excepcion es unchecked
		boolean correcto = true;
		do{
			System.out.println("Introduzca los numeros para dividir");
			try {
				int numero = sc.nextInt();
				int numero2 = sc.nextInt();
				
				int resultado = numero / numero2;
				
				System.out.println("El resultado es: " + resultado);
				correcto = true;
			}catch(InputMismatchException e) {
				System.out.println("Error: Debe de introducir un número");
				sc.nextLine();//SI recogemos un entero mal hay que limpiar el scanner
				correcto = false;
			}catch(ArithmeticException e) {
				System.out.println("Error: El denominador no puede ser un 0");
				correcto = false;
			}catch(Exception e) {
				correcto = false;
				System.out.println("Error: Ha ocurrido algún error desconocido");
			}
		}while(!correcto);

		System.out.println("Acabado el programa");
		hola1("dfas");
	}
	
	public static void hola1(String v) {
		hola2(v);
	}
	
	public static void hola2(String p) {
		
	}
}
