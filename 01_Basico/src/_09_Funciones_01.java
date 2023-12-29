
public class _09_Funciones_01 {

	//Una "función" es un bloque de código que realiza 
	//alguna operación
	
	//En programación orientada a objetos (POO o OOP en inglés)
	//a las funciones se le llaman "métodos"
	
	//Los objetivos de las funciones son básicamente 2:
	//1. Reutilizar código
	//2. Ordenar el código
	
	//Los métodos o funciones pueden tener parámetros de entrada
	//y parámetros de salida
	public static void main(String[] args) {
		System.out.println("Bienvenidos a las funciones o métodos en Java");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Autor: Félix de Pablo Lobo");
		
		System.out.println("Bienvenidos a las funciones o métodos en Java");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Autor: Félix de Pablo Lobo");
		
		System.out.println("Bienvenidos a las funciones o métodos en Java");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Autor: Félix de Pablo Lobo");

		//Para invocar una función o método lo haremos a traves de su nombre
		bienvedida();
		bienvedida();
		
		dameElNombreDelAutor();
		
		//Normalmente, cuando invocamos una función o método que devuelve un
		//valor, tenemos que hacer algo con él.
		System.out.println(dameElNombreDelAutor());
		//Notese como tenemos la variable "cadena" tanto en el método "main"
		//con en el método "dameElNombreDelAutor()"
		//NO son la misma variable, el ciclo de vida de una variable es
		//desde que se declara hasta el FINAL del bloque donde se creo
		String cadena = dameElNombreDelAutor();
		//String cadena = dameElNombreDelAutor();//Error
		System.out.println("El nombre del autor es: " + cadena);
		
		int numero2 = 67;
		//int numero2 = 67;//Error no se puede declarar una variable 2 veces
		//Creamos un bloque en java
		{
			int numero = 5;//esta variable morira cuando salga del bloque
		}
		int numero = 5;//podemos volver a declarar esta variable porque ya murio!
		
		int numero3 = 78;
		{
			//En este caso SI podemos usar la variable 'numero3' porque
			//sigue viva, morirá cuando salga del método main
			System.out.println(numero3);
			//int numero3 = 100;
		}
		
		//invocamos método imprimirNombreAutor()
		imprimirNombreAutor("Félix de Pablo Lobo");
		imprimirNombreAutor("Luis Mariano de todos los santos du silva");
		String autor = "Federico Garcia Lorca";
		imprimirNombreAutor(autor);
		
		int potencia = calcularPotenciaCuadrada(6);
		System.out.println("La potencia es: " + potencia);
		potencia = calcularPotenciaCuadrada(12);
		System.out.println("La potencia es: " + potencia);
		System.out.println("la potencia directamente es: " + calcularPotenciaCuadrada(9));
		
		String nombreFinal = concatenarNombreYApellidos("Gabriel", "Garcia Marquez");
		System.out.println("El nombre final es: " + nombreFinal);
		
		//Cada vez que quiera imprimir, en vez de usar syso puedo usar 'im'
		im("Esto es lo que quiero imprimir");
		im("Esto es otra impresion");
	}//Fin del método main
	
	//Las funciones o métodos en Java las podemos declarar dentro de una clase
	//pero ojo!!! Fuera del método "main", es decir no podemos declarar métodos
	//o funciones dentro de métodos o funciones.
	
	//Las funciones para declararlas tienen que tener un nombre de función o método
	//En los lenguajes compilados, podemos poner los métodos en cualquier parte
	//de nuestro código, pero siempre dentro de una clase. En lenguajes NO
	//compilados (como JavaScript) tenemos que declarar ANTES un método para 
	//poder usarlo.
	
	//En este caso vamos a declarar el método "bienvenida"
	//Este método NO tendrá parametros de entrada. Los parámetros de entrada
	//van entre los paréntesis y separados por "," y son equivalentes a las variables
	
	//Este método NO tendrá parametros de salida, y se especifica con la palabra
	//"void" justo antes del nombre del método. Que una función o método no tenga
	//parámetros de salida quiere decir que NO devuelve nada.
	public static void bienvedida() {//llave de apertura del método "bienvenida"
		System.out.println("Bienvenidos a las funciones o métodos en Java");
		System.out.println("---------------------------------------------");
		System.out.println("---------------------------------------------");
		System.out.println("Autor: Félix de Pablo Lobo");
	}//llave de cierre del método "bienvenida"
	
	//En este caso vamos a hacer una función que devuelva una cadena de texto
	//Para ello debemos de poner el tipo de dato que devuelve justo antes
	//del nombre de la función (sustituyendo la palabra "void")
	public static String dameElNombreDelAutor() {
		//Cuando una función devuelve un dato debe de tener
		//en algún momento la palabra "return" con el tipo de
		//dato que queremos devolver
		
		//Cuando se ejecute el "return" se acabará la función
		//return "Félix de Pablo Lobo";
		
		//Esto es equivalente a lo anterior
		//La variable "cadena" nacerá en la línea siguiente y
		//morira cuando salga del bloque, en este caso el final
		//del método
		String cadena = "Félix de Pablo Lobo";
		return cadena;
	}
	
	//Método con un parametro de entrada y ningún parámetro de salida
	//Los parámetros de entrada moriran cuando se acabe la función
	public static void imprimirNombreAutor(String nombre) {
		System.out.println("El nombre del autor es: " + nombre);
	}
	
	//Metodo con un parámetro de entrada y un parámetro de salida
	public static int calcularPotenciaCuadrada(int numero) {
		int potencia = numero * numero;
		return potencia;
	}
	
	//Metodo con dos parámetros de entra y un parametro de salida
	//Nota: Los parámetros de entrada van de 0..N
	//		Los parámetros de salida van de 0..1
	public static String concatenarNombreYApellidos(String nombre, String apellido) {
		//Una vez declarado un parámetro de entrada, NO podemos declarar otra variable
		//con el mismo nombre
		//String nombre = "Felix";//Error, ya existe la variable nombre
		String nombreCompuesto = nombre + " " + apellido;
		return nombreCompuesto;
	}
	
	//La utilidad principal de las funciones es ayudarnos a reutilizar código
	public static void im(String cadena) {
		System.out.println("----------------------------");
		System.out.println("salida: " + cadena);
		System.out.println("----------------------------");
	}
	
}//Fin de la clase