import java.util.Scanner;

public class OperacionesMatematicas {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int contador = 1;
		double numero1 = pedirNumero("Numero"+contador++);
		double numero2 = pedirNumero("Numero"+contador++);
				
		double resultadoSuma = sumar(numero1,numero2);
		//resultadoSuma = sumar(2,3,5);
		double resultadoResta = restar(numero1,numero2);
		double resultadoMultiplicacion = multiplicar(numero1,numero2);
		double resultadoDivision = dividir(numero1,numero2);
		
		mostrarValores(resultadoSuma, 
				resultadoResta, 
				resultadoMultiplicacion, 
				resultadoDivision);

	}
	
	public static double pedirNumero(String numero){
		
		System.out.println("Introduzca el " + numero + ":");
		double dNumero = sc.nextDouble();
		return dNumero;
	}
	
	public static double sumar(double numero1,double numero2){
		double suma = numero1 + numero2;
		return suma;
	}
	
	public static int sumar(int numero1,int numero2){
		int suma = numero1 + numero2;
		return suma;
	}
	
	public static double sumar(double numero1,double numero2,double numero3){
		double suma = numero1 + numero2 + numero3;
		return suma;
	}
	
	public static double sumar(double... valores){
		return 0;
	}
	
	public static double restar(double numero1,double numero2){
		double resta = numero1 - numero2;
		return resta;
	}
	
	public static double multiplicar(double numero1,double numero2){
		double multiplicacion = numero1 * numero2;
		return multiplicacion;
	}
	
	public static double dividir(double numero1,double numero2){
		double division = numero1 / numero2;
		return division;

	}
	
	public static void mostrarValores(double suma,
									double resta,
									double multiplicacion,
									double division){
		System.out.println("--------------");
		System.out.println("--Resultados--");
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
		System.out.println("Multiplicacion: " + multiplicacion);
		System.out.println("Division: " + division);
	}
}
