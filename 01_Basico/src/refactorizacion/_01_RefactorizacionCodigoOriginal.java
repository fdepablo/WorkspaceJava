package refactorizacion;

import java.util.Scanner;

//Podemos mover el fichero a otra localización con "move" o arrastrando el
//fichero

//Podemos copiar el fichero a otra localización con "copy". Esta opción está al
//pulsar botón derecho sobre el fichero. Se puede hacer tambien con "ctrl + C"

//Podemos pegar el fichero una vez compiado. Esta opción está al
//pulsar botón derecho sobre el fichero. Se puede hacer tambien con "ctrl + V"

//Podemos cambiar el nombre de una clase haciendo un "rename" del fichero
public class _01_RefactorizacionCodigoOriginal {

	public static void main(String[] args) {
		//Podemos extraer esta cadena a una variable, para ello 
		//haremos un "Extract local variable". Podriamos hacer lo  mismo 
		//si fuera un número u otro valor.
		System.out.println("Pepe");
		System.out.println("Pepe");
		
		if("Pepe".length() == 4) {
			System.out.println("La longitud de Pepe es: 4");
		}else {
			System.out.println("La longitud de Pepe no es 4");
		}
		//Una vez que hayamos extraido la cadena a una variable local, 
		//haremos un refactor del nombre con "rename"

		//Aqui vamos a convertir la cadena "Bienvenidos a mi programa"
		//a una constante, mediante la opción "Extract constant"
		System.out.println("Bienvenidos a mi programa");
		
		//Esta variable la hemos convertido a atributo
		//antes era, int numero = 5;
		int numero = 5;
		System.out.println(numero);
		
		System.out.println("*****************************");		
		int resultado = sumar(10,2);
		System.out.println(resultado);
	}
	
	//Podemos cambiar la firma de un metodo con "Change Method Signature"
	private static int sumar(int a, int b) {
		int suma = a + b;
		return suma;
	}
	
	//Extracion de metodos, podemos extraer parte de codigo a otros métodos
	//mediante la opción "Extract method"
	public static void operar(int operacion) {
		if(operacion == 0) {
			System.out.println("Damos alta el nombre, opcion elegida " + operacion);
			Scanner sc = new Scanner(System.in);
			String nombre = sc.nextLine();
			System.out.print("Dato recogido correctamente");
			System.out.println("Dando de alta el nombre " + nombre);
		}else if(operacion == 1) {
			System.out.println("Damos de baja el nombre, opcion elegida " + operacion);
			Scanner sc = new Scanner(System.in);
			String nombre = sc.nextLine();
			System.out.print("Dato recogido correctamente");
			System.out.println("Dando de baja el nombre " + nombre);
		}
	}
}
