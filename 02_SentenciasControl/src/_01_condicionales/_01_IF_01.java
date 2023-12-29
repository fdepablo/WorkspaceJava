package _01_condicionales;

import java.util.Scanner;

public class _01_IF_01 {

	public static void main(String[] args) {
		// Los programas, como hemos visto, se ejecutan línea a línea hasta
		//que llegan al fin del bloque del método 'main' y entonces se acaba
		//el programa.
		
		//Existen diferentes maneras de alterar esta secuencialidad, y muchas
		//veces es necesaria para crear algorimos o hacer determinadas
		//funcionalidades.
		
		//Una manera es mediante los CONDICIONALES. Los condicionales evaluan
		//una expresión BOOLEAN, y en función de si la expresión es TRUE o 
		//FALSE, se tomará una ruta u otra.
		
		//Una manera para hacer condiciones es mediante la palabra reservada
		//'if'. La condición a evaluar irá siempre entre paréntesis
		
		boolean cierto = true;
		if(cierto)//Como la variable 'cierto' es TRUE, entramos dentro del condicional
			System.out.println("La variable tiene valor TRUE");
		
		cierto = false;
		if(cierto)//Como la variable 'cierto' es FALSE, NO entramos dentro del condicional
			System.out.println("La variable tiene valor FALSE (esto no se imprime, ulio)");
		
		//Puedo jugar con operadores para alterar la expresión boolean
		if(!cierto)
			System.out.println("La variable tiene valor FALSE");
		
		int numero = 7;
		if(numero > 5)
			System.out.println("La variable 'numero' es mayor que 5");
		
		numero = 4;
		if(numero > 5)
			System.out.println("La variable 'numero' es mayor que 5");
		
		//Notese que solamente afecta a la sentencia inmediatamente siguiente
		//Si queremos que la condicion afecta a más de una línea, debemos
		//de usar un 'bloque'
		numero = 6;
		if(numero > 5) {
			System.out.println("Hurra!! El numero es mayor que 5");
			System.out.println("El numero es: " + numero);
		}
		//IMPORTANTE: Se considera buena práctica de programación en Java
		//hacer siempre bloques en los condicionales, ya que facilita la
		//lectura. Es decir, no importa si haceis una línea o varias, 
		//siempre en conveniente hacer un bloque
		
		//La sentencia 'if' puede contener otra palabra reservada en caso
		//de que no se cumpla la condición. La palabra es 'else'
		if(numero > 5) {
			System.out.println("El número es mayor que 5");
		}else {
			System.out.println("El número es menor o igual que 5");
		}
		
		//Normalmente las condiciones se basan en entradas de usuario o parámetros
		//de entrada
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca un número para saber si es mayor, igual o menor 5");
		numero = sc.nextInt();
		if(numero > 5) {
			System.out.println("El número es mayor que 5");
		}else {
			System.out.println("El número es menor o igual que 5");
		}
		
		//Existe otra variente del 'if' que nos da la opción de poner más condiciones
		//a valorar, que es 'else if'. Podemos poner tanto 'else if' como queramos.
		if(numero > 5) {
			//Si entra por esta condicion, NO valora el 'else if' y por supuesto
			//tampoco entraría por el 'else'
			System.out.println("El número es mayor que 5");
		}else if(numero < 5){ 
			//Si no se cumple la condicion del 'if', valora esta otra opción
			//pero ojo! Si la condición del if se cumple NO se valora esta
			//otra opción
			System.out.println("El número es menor que 5");
		}else if(numero == 5){ //OJO! Para comparar valores se usa '=='
			//Si no cumple el primer 'if' y no cumple el segundo 'else if'
			//entonces valoramos esta opción
			System.out.println("El número es igual a 5");
		}/*else {//El 'else' lo podemos usar si lo necesitamos, pero en 
				//este caso no tiene sentido
			System.out.println("El número es menor o igual que 5");
		}*/
		
		//Podemos ver como los bloques 'else if' y 'else' son totalmente
		//optativos. Además, el bloque 'else if' se puede repetir, mientras
		//que el bloque 'else' solo puede haber uno (si lo hay).
		
		System.out.println("Fin de programa");
	}

}
