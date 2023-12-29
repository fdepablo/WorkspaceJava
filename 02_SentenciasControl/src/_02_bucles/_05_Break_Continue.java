package _02_bucles;

public class _05_Break_Continue {

	public static void main(String[] args) {
		// Hay veces que tenemos que alterar el flujo de ejecución de los bucles
		// Esta práctica conviene evitar, sobre todo al principio cuando estamos
		// aprendiendo algoritmos.
		
		// Para alterar el flujo tenemos dos palabras reservadas:
		// 1- break
		// 2- continue
		
		// "break"
		// Con esta palabra rompe la ejecución el bucle donde se encuentra
		// es decir, sale inmediantamente
		
		//Voy a imprimir todos los números naturales del 1 al 7
		for(int i = 1; i <= 10; i++) {
			System.out.println("Numero: " + i);
			if(i == 7) {
				break;//Cuando el número valga 7, dejo de ejecutar el bucle
			}
		}
		//El ejemplo de aquí arriba se puede hacer sin "break" mejorando
		//la condición de parada del bucle (i <= 7)
		
		//OJO, rompe la ejecución del bucle donde se ejecuta, PERO si
		//esta el bucle anidado, NO romple el bucle exterior
		
		System.out.println("---------------- BREAK -------------------------");
		//Vamos a imprimir la tabla de multiplicar de los 5 primeros
		//numeros pero solo los resultados del 1 al 5
		for(int i = 1; i <= 10; i ++) {
			System.out.println("Tabla de multiplicar del " + i);
			for(int j = 1; j <= 10; j++) {
				System.out.println(j + " x " + i + " es igual a " + (i * j));
				if(j == 5) {
					break;//Este "break" rompe el bucle de la "j" NO rompe el bulce "i"
				}
			}
			if(i == 5) {
				break;
			}
		}
		
		System.out.println("------------- CONTINUE --------------------");
		
		//"continue"
		//Esta palabra se usa cuando queremos dejar de ejecutar el código del
		//bucle y queremos pasar a la siguiente iteración. OJO, no rompe
		//completamente la ejecución del bucle
		
		//Imprimir todos los numeros pares del 1 al 10
		for(int i = 1; i <= 10; i ++) {
			if(i % 2 == 0) {
				System.out.println("Numero par: " + i);
			}			
		}
		
		System.out.println("------------------------------");
		
		for(int i = 1; i <= 10; i ++) {
			if(i % 2 != 0) {
				continue;//Saltamos a la siguiente iteracion del bucle
						//por lo tanto, no se ejecutaria la linea 68
			}	
			System.out.println("Numero par: " + i);
		}
		
		//Vamos a imprimir la tabla de multiplicar de los 6 primeros
		//numeros pares pero solo los resultados del 1 al 6 pares
		for(int i = 1; i <= 6; i ++) {
			if(i % 2 != 0) {
				continue;//volveriamos a la linea 73
			}
			System.out.println("Tabla de multiplicar del " + i);
			for(int j = 1; j <= 6; j++) {
				if(j % 2 != 0) {
					continue;//volveriamos a la línea 78
				}
				System.out.println(j + " x " + i + " es igual a " + (i * j));
			}
		}

	}

}
