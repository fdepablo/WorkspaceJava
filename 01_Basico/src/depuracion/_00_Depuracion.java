package depuracion;

public class _00_Depuracion {
	//para depurar el codigo en vez de ejecutar con run as -> run se hara con debug as -> debug
	public static void main(String[] args) {
		//podemos poner puntos de interrupcion
		//en cualquier momento podemos pulsar f8 para hacer que el programa ejecute hasta el siguiente
		//punto de interrupción, si no hubiera, hasta el fin del programa
		System.out.println("Hola mundo!!");
		//si pulsamos f6 iremos a la siguiente linea
		System.out.println("Estoy depurando el codigo");
		System.out.println("Sigo depurando");
		
		int variable = 5;
		
		variable += 6;
		variable += 9;
		variable *= 3;//variable = variable * 3;
		variable /= 2;
		
		//si pulsamos f5 pasaremos dentro de la función,f6 para siguiente linea
		int resultado = sumar(variable, 90);
		
		System.out.println(resultado);
		
	}
	
	public static int sumar(int num1, int num2) {
		int resultado = num1 + num2;
		return resultado;
	}
}
