import java.util.Scanner;

public class ProgramaPrimos {

	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numero = pedirNumero();
		if(esPrimo(numero)){
			System.out.println("El numero es primo");
		}else{
			System.out.println("El numero NO es primo");
		}
	}
	
	public static int pedirNumero(){
		System.out.println("Introduzca el numero: ");
		int numero = sc.nextInt();
		return numero;
	}
	
	public static boolean esPrimo(int numero){
		boolean esPrimo = true;
		
		if(numero == 0){
			return !esPrimo;
		}
		
		for(int i = 2;i < (numero/2);i++){
			if(numero % i == 0){
				esPrimo = false;
				break;
			}
		}
		
		return esPrimo;
	}

}
