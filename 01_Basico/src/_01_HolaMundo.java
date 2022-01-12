
public class _01_HolaMundo {

	int variableDeInstancia = 0;
	static int variableDeClase = 0;
	
	//Esto es una funcion o metodo y normalmente van 
	//entre un bloque "{}"
	public static void main(String[] args) {
		//los comentarios empiezan por doble barra
		/*
		 * esto es un cometario
		 * de mas de una linea
		 */
		
		//Esto son setencias, que son instrucciones ejecutables
		//Una sentenica acaba por ";"
		System.out.println("Hola mundo desde eclipse");
		System.out.println("Esto es otra traza");
		System.out.println("Otra mas");
		//Aqui tambien vemos como poner puntos
		//de interrupción y ejecutar en modo depuración
		
		
		//Variables locales primitivas
		int i = 0;
		//tipo long son naturales pero tenemos mayor rango
		long l = 1111111111111L;
		long l2 = 34444;
		float f = 23.45F;
		double d = 34.44;
		
		char c = 'a';
		boolean b = true;
		boolean b1 = false;
		String s = "cadena";
		
		System.out.println(s);
		String s2 = s + " dos";
		System.out.println(s2);
		String s3 = "3";
		String s4 = "4";
		String s5 = s3 + s4;
		System.out.println(s5);
		int numero1 = 3;
		int numero2 = 4;
		int numero3 = numero1 + numero2;
		System.out.println(numero3);
		System.err.println("Esto es un error!!! :OOOOO");
		//Las variables deben de empezar por una letra, un caracter
		//o el simbolo del dolar
		int holaATodos = 1;
		//Se distingue en java entra mayusculas y minusculas
		String hola = "hola";
		String Hola = "Otro hola diferente";
		
		//System.out
		//System.in
		//System.err
	}

}
