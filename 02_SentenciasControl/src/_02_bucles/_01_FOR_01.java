package _02_bucles;

public class _01_FOR_01 {
	
	//Existen otro tipo de sentencias de control que sirven para alterar al flujo
	//normal de ejecución de un programa, que son los bucles o sentencias repetitivas
	
	//Con la sentencia "for" podemos repetir un bloque de código de 1 a N veces
		
	public static void main(String[] args) {
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		System.out.println("Hola en este tema vamos a hablar de bucles");
		
		//Para hacer repeticiones mejor usar un bucle, en este caso vamos a
		//hacerlo con el bucle "for"
		//Para hacer un bucle "for" usaremos la palabra reservada "for" :)
		//Dentro de la estructura "for" podemos encontrar las siguientes partes
		//1- Inicio de la variable de control de bucle, normalmente una variable entera "int"
		//2- Condicion de ejecución de bucle. Es decir, cuando se tiene que seguir
		//ejecutando el bucle. Es una expresion "boolean"
		//3- Incremento de la variable de control de bucle
		//Estas tres partes van entre parentesis y separadas por ";"
		System.out.println("------------------ FOR ---------------------");
		for(int i = 1; i <= 10;i++)
			System.out.println("Hola en este tema vamos a hablar de bucles");
		
		System.out.println("------------------ FOR 100000---------------------");
		for(int i = 1; i <= 100_000;i++)
			System.out.println("Hola en este tema vamos a hablar de bucles");
		
		//Es habitual
		System.out.println("------------------ FOR CON BLOQUE---------------------");
		for(int i = 1; i <= 1_000;i++) {
			System.out.println("Hola en este bucle");	
			System.out.println("Vamos a ejecutar varias sentencias");
		}
		
		System.out.println("------------------ FOR USANDO LA VARIABLE DE CONTROL---------------------");
		for(int i = 1; i <= 1_000;i++) {
			System.out.println("Hola este bucle lo hemos ejecutado " + i);
		}//Cuando salgamos del bucle, la variablde de control que hayamos
		//creado, morira.
		//	System.out.println("No puedo acceder a la variable 'i'" + i);//
		
		System.out.println("------------------ FOR SOLO PARES---------------------");
		//Imprimir solo los pares
		for(int i = 0; i <= 1_000;i += 2) {
			System.out.println("Hola este bucle lo hemos ejecutado " + i);
			//i++;//No es buena practica alterar la variable de control de bucle fuera del "for"
		}
		//Normalmente usamos la palabra "iteracion" para referirnos a cada
		//salto del bucle
		
		//Todas las partes del "for" son OPTATIVAS
		//for(;;) {
			//OJO, cuidado con bucles que no paran porque podemos hacer
			//un bucle infinto
			//System.out.println("Esto es un bulce infinito");
		//}
		
		//A veces podemos hacer que no entre en un bucle por error de programacion
		for(int i = 0; i > 1_000;i += 2) {
			System.out.println("Esto no se imprime nunca " + i);
		}
		
		//A veces podemos hacer que bucles infinitos por error
		//Bueno, en este caso se parara cuando llegue al maximo rango del "int"
		//for(int i = 1001; i > 1_000;i += 1) {
		//	System.out.println("Esto se imprime muuuuuchas veces " + i);
		//}
		
		//Recomendaciones
		//1. Escribir la variablde de control en un papel y ver como se va incrementado
		//respecto al tiempo
		//2. Siempre hacer bloques, aunque solo sea una sentencia
		
		//Podemos declarar la variable de control de bucle fuera del bucle
		int i = 0;
		for(i = 0; i <= 1_000;i += 2) {
			System.out.println("Hola este bucle lo hemos ejecutado " + i);
		}
		System.out.println("Ahora si que puede acceder a la variable de control: " + i);
		
		//Usando bucles podemos resolver de varias maneras los ejercicios
		//jugando con la variable de control y las condiciones de ejecución
		for(int j = 0; j <=9; j++) {
			System.out.println("Hola a todos");
		}
		
		for(int j = 1; j <=10; j++) {
			System.out.println("Hola a todos");
		}
		
		for(int j = 10; j <=20; j++) {
			System.out.println("Hola a todos");
		}
		
		//Las tres maneras anteriores son equivalente, imprimen 10 veces por pantalla
		
		//Podemos seguir usando variables para las condiones de bucle
		int numero = 10;
		for(int j = 1; j <= numero; j++) {
			System.out.println("Hola 10 veces");
		}
		
		//Podemos invocar funciones dentro del un bucle "for"
		for(int j = 1; j <= numero; j++) {
			imprimirNumero(j);
		}
		
		//De igual manera podemos invocar funciones que hagan bucles for
		imprimirXVecesNumero(10);
		imprimirXVecesNumero(100);
	}
	
	public static void imprimirNumero(int numero) {
		System.out.println("El numero es : " + numero);
	}
	
	public static void imprimirXVecesNumero(int numero) {
		for(int j = 1; j <= numero; j++) {
			imprimirNumero(j);
		}
	}
}
