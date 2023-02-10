package depuracion;

public class _01_DepuracionBasica {
	//Para depurar el código en vez de ejecutar con run as -> run 
	//se hara con debug as -> debug
	public static void main(String[] args) {
		//Podemos poner puntos de interrupción, haciendo doble click sobre la linea que 
		//queremos
		//En cualquier momento podemos pulsar F8 para hacer que el programa ejecute hasta 
		//el siguiente punto de interrupción, si no hubiera mas, hasta el fin del programa
		System.out.println("Hola mundo!!");
		//si pulsamos F6 iremos a la siguiente linea
		System.out.println("Estoy depurando el codigo");
		System.out.println("Sigo depurando");
		
		int variable = 5;
		
		variable += 6;//variable = variable + 6;
		variable += 9;
		variable *= 3;
		variable /= 2;

		System.out.println(variable);
		
		String nombre = "Harry potter";
		nombre = "Steve Rogers";
		
		System.out.println(nombre);
		//si pulsamos F5 pasaremos dentro del método, F6 para siguiente linea
		int resultado = sumar(110, 90);		
		System.out.println(resultado);
		
		resultado = dividir(10, 2);		
		System.out.println(resultado);
		
	}
	
	public static int sumar(int num1, int num2) {
		int resultado = num1 + num2;
		return resultado;
	}
	
	public static int dividir(int num1, int num2) {
		return num1 / num2;
	}
}
