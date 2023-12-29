package _02_bucles;

public class _06_EjerciciosControlBucles {
	public static void main(String[] args) {
		//Escribir como van variando las variables y escribir
		//la salida parciales por pantalla para cada una de las
		//iteraciones de los bucles
		//Hacerlo en un fichero ".txt"
		
		//Ejemplo 1
		System.out.println("--------- Ejemplo 1 --------");
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		//ejemplo1.txt
		//Iteracion 1
		//	i = 1
		//	salida = 1
		//Iteracion 2
		//	i = 2
		//	salida = 2
		//Iteracion 3
		//	i = 3
		//	salida = 3
		//Iteracion 4
		//	i = 4
		//	salida = 4
		//Iteracion 5
		//	i = 5
		//	salida = 5
		
		//Ejemplo 2
		System.out.println("--------- Ejemplo 2 --------");
		for(int i = 1; i <= 3; i++) {
			if(i == 2) {
				System.out.println(i + 2);
			}			
		}
		//ejemplo2.txt
		//Iteracion 1
		//	i = 1
		//Iteracion 2
		//	i = 2
		//	salida = 4
		//Iteracion 3
		//	i = 3
		
		//Ejercicio 1
		for(int i = 1; i <= 3; i++) {
			if(i % 2 == 1) {
				System.out.println(i + 1);
			}			
		}
		
		//Ejercicio 2
		for(int i = 1; i <= 6; i+=2) {
			if(i % 2 == 0) {
				System.out.println(i - 1);
			}			
		}
		
		//Ejercicio 3
		for(int i = 1; i <= 6; i+=3) {
			if(i % 2 == 0) {
				System.out.println(i - 1);
			}else {
				System.out.println(i + 1);
			}
		}
		//Ejercicio 4
		for(int i = 1; i <= 6; i++) {
			if(i % 2 == 0) {
				System.out.println(i - 1);
			}else {
				i++;
			}
		}
		//Ejercicio 5
		for(int i = 1; i <= 6; i++) {
			int variable = 1;
			if(i % 2 == 0 && variable != 3) {
				System.out.println(i);
			}
			variable ++;
		}
		
		//Ejercicio 6
		for(int i = 1; i <= 6; i++) {
			int variable = 1;
			if(i % 2 != 0 || variable != 3) {
				System.out.println(i);
			}
			variable += 2;
		}
		
		//Ejercicio 7
		for(int i = 1; i <= 5; i++) {
			if(i % 2 == 0) {
				System.out.println(i - 1);
			}	
			if(i == 3) {
				break;
			}
		}
		
		//Ejercicio 8
		for(int i = 1; i <= 5; i++) {
			if(i % 2 == 0) {
				System.out.println(i - 1);
			}	
			if(i == 3) {
				continue;
			}
		}
		
		//Ejercicio 9
		for(int i = 1; i <= 5; i++) {
			for(int j = 1; j <= 5; j++) {
				if(j == 3) {
					continue;
				}
				System.out.println(i);
			}
			if(i == 4) {
				System.out.println(45);
				break;
			}
		}
		
		//Ejercicio 10
		for(int i = 1; i <= 5; i++) {
			System.out.println(i++);
		}
		
		//Ejercicio 11
		for(int i = 1; i <= 5; i++) {
			System.out.println(++i);
		}
		
		//Ejercicio 12
		for(int i = 0; i <= 5; i+=2){
			System.out.println(++i);
		}
	}
}
