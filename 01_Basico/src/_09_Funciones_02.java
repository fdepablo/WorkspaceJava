
public class _09_Funciones_02 {

	public static void main(String[] args) {
		imprimirLong(34);
		imprimirSuma(45, 55);
		//imprimirLong("pepe");
		imprimirCadena("pepe");
		imprimirCadena("maria", "luisa");
		imprimirCadena("Manolo", 34);
		
		//Gracias a la sobrecarga puedo usar la funcion imprimir
		//y dependiendo del parámetro de entrada, se invocará
		//una función u otra
		imprimir(34.78);
		imprimir("Pepe");
		imprimir(2_000_000_000);
		
		System.out.println("Fin de programa");
	}
	
	//Las funciones tienen las siguientes partes
	//1. Visibilidad, desde donde se invocar a la función. De momento haremos
	//que se pueda invocar desde cualquier parte -> public
	//2. Tipo de función, que puede ser estática o dinámica. De momento todas
	//nuestras funciones serán estaticas -> static
	//3. Parámetro de salida, el tipo de valor devuelto por la función. En caso
	//de que no devuelva nada se usa la palabra "void". Solo se puede devolver
	//un valor y se debe hacer con la palabra "return" dentro de la función. 
	//Cuando se ejecute la palabra "return" se acabará la función
	//4. Nombre de la función, representa como identificar e invocar la función
	//El nombre de la función sigue la misma regla que los nombres de las funciones.
	//Además se debe usar 'lowerCamelCase' (como en las variables)
	//5. Parámetros de entrada, se ponen entre paréntesis las variables que necesita
	//la función para hacer su operación. Puede haber varios parámetros de entrada
	//separados por ",".
	//6. Las funciones siempre van con un bloque '{}'.
	public static double estaEsMiFuncion(int numero1, double numero2, String cadena1) {
		//Operaciones que realiza la función
		return 0;
		//El codigo de abajo da error en tiempo de compilación porque es inalcanzable.
		//El "return" pone fin a la función
		//System.out.println("Mensaje");//Error en tiempo de compilación
	}
	
	//Podemos invocar a funciones dentro de otras funciones y suele ser muy habitual
	public static void imprimirLong(long n1) {
		System.out.println("----------------------------");
		System.out.println("salida: " + n1);
		System.out.println("----------------------------");
	}
	
	public static void imprimirSuma(int n1, int n2) {
		long resultado = n1 + n2;
		imprimirLong(resultado);
	}
	
	//Podemos invocar a funciones dentro de otras funciones y suele ser muy habitual
	public static void imprimirCadena(String s1) {
		System.out.println("----------------------------");
		System.out.println("salida: " + s1);
		System.out.println("----------------------------");
	}
	//En java existe el concepto de Firma de Función
	//La firma de una función es lo que hace que Java distinga univocamente
	//una función de otra
	//En Java la firma de una función esta compuesta de:
	//1. El nombre de la función
	//2. El número de parámetros de entrada de una función
	//3. El tipo de parámetros de entrada de una función
	//NO, pertenece el parámetro de salida
	
	//La siguiente función daria erro, porque tiene la MISMA FIRMA que la
	//función de arriba. Para Java ambas funciones son iguales
	/*
	public static void imprimirCadena(String s1) {
		System.out.println("----------------------------");
	}
	*/
	//La función de arriba no daría error si cambiamos el nombre
	
	//Creamos otra funcion que se llame igual, PERO cambiamos el número
	//de parámetros de entrada. Por lo tanto, la firma es diferente
	public static void imprimirCadena(String s1,String s2) {
		System.out.println("----------------------------");
		System.out.println("Salida 1: " + s1);
		System.out.println("Salida 1: " + s2);
		System.out.println("----------------------------");
	}
	
	//Ahora cambiamos la firma de la función, variando el TIPO de parámetros
	//de entrada
	public static void imprimirCadena(String s1,double d2) {
		System.out.println("----------------------------");
		System.out.println("Salida 1: " + s1);
		System.out.println("Salida 1: " + d2);
		System.out.println("----------------------------");
	}
	
	//Concepto de SOBRECARGA de funciones.
	//En java sobrecargamos una función cuando dos o mas funciones tienen
	//el mismo nombre pero distinta firma, es decir, cambian el número de
	//parametros de entrada o cambia el tipo de parámetros de entrada.
	
	//La funcion System.out.println() esta sobrecargada, según el parámetro
	//de entrada que se pase, se invoca a un println o a otro.
	
	//Vamos a sobrecargar la funcion imprimir(), para hacerla genérica
	public static void imprimir(long valor) {
		System.out.println("-------- long --------------");
		System.out.println("salida: " + valor);
		System.out.println("----------------------------");
	}
	
	public static void imprimir(String valor) {
		System.out.println("------- String -------------");
		System.out.println("salida: " + valor);
		System.out.println("----------------------------");
	}
	
	public static void imprimir(double valor) {
		System.out.println("------- double -------------");
		System.out.println("salida: " + valor);
		System.out.println("----------------------------");
	}
	
	//La siguiente función daría error en tiempo de compilación porque
	//tiene la misma firma que el método de arriba. El parámetro de
	//salida NO pertenece a la firma de un método, por lo tanto
	//Java no tiene manera de distinguirlos
	/*
	public static String imprimir(double valor) {
		System.out.println("------- double -------------");
		System.out.println("salida: " + valor);
		System.out.println("----------------------------");
		return "Manuel no te arrime a la pared, que te va a llenar de cal";
	}*/
	
}
