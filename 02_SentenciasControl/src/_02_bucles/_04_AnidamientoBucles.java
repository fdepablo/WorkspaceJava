package _02_bucles;

public class _04_AnidamientoBucles {

	public static void main(String[] args) {
		// Es muy habitual anidar también bucles, al igual que anidabamos "if"
		// Se suele usar para recorrer o implementar matrices bidimensionales
		
		//Por ejemplo, si se pidiera imprimir por pantalla la tabla de
		//multiplicar de los 10 primeros número naturales.
		
		System.out.println("Tabla de multiplicar del 1");
		for(int i = 1; i <= 10; i++) {
			System.out.println("1 x " + i + " es igual a " + (i * 1));
		}
		
		System.out.println("Tabla de multiplicar del 2");
		for(int i = 1; i <= 10; i++) {
			System.out.println("2 x " + i + " es igual a " + (i * 2));
		}
		
		System.out.println("Tabla de multiplicar del 3");
		for(int i = 1; i <= 10; i++) {
			System.out.println("3 x " + i + " es igual a " + (i * 3));
		}
		
		//De esta manera si nos pidiran imprimir las tablas de multiplicar
		//de los 1000 primeros números, tendríamos que repetir esto 1000 veces
		
		//Mejor aplicar anidamiento de bucles
		
		System.out.println("-----------------------------------------");
		//Este bulce va a llevar el control del numero de veces que queremos repetir la
		// tabla de multiplicar
		for(int i = 1; i <= 10; i ++) {
			System.out.println("Tabla de multiplicar del " + i);
			for(int j = 1; j <= 10; j++) {
				System.out.println(j + " x " + i + " es igual a " + (i * j));
			}
		}
		
		System.out.println("------------------- Coordenadas en 3D ------------------------");
		
		// Podemos trabajar con 3 dimensiones
		for(int i = 1; i <= 10; i ++) {
			for(int j = 1; j <= 10; j++) {
				for(int k = 1; k <= 10 ; k++) {
					System.out.println("Coordenada: " + "(" + i + "," + j + "," + k + ")");
				}
			}
		}
	}

}
