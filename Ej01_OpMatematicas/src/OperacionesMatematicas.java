import java.util.Scanner;

public class OperacionesMatematicas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el numero1:");
		double dNumero1 = sc.nextDouble();
		System.out.println("Introduzca el numero2:");
		double dNumero2 = sc.nextDouble();
		
		System.out.println("--------------");
		System.out.println("--Resultados--");
		
		double suma = dNumero1 + dNumero2;
		double resta = dNumero1 - dNumero2;
		double multiplicacion = dNumero1 * dNumero2;
		double division = dNumero1 / dNumero2;
		
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
		System.out.println("Multiplicacion: " + multiplicacion);
		System.out.println("Division: " + division);
		sc.close();
	}
}
