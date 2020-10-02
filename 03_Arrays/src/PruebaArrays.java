import java.util.Arrays;

public class PruebaArrays {
	public static void main(String[] args) {
		//El tamaño es fijo, y se inicializan a 0
		int[] arrayEnteros = new int[10];
		arrayEnteros[0] = 4;
		arrayEnteros[1] = 9;
		int tamañoArray = arrayEnteros.length;
		//el tamaño es con ell que se creo, no del numero de
		//elementos
		System.out.println("El tamaño del array es: " + tamañoArray);
		
		for(int i = 0;i<tamañoArray;i++){
			System.out.println("El valor en la posicion "
					+ i + " es " + arrayEnteros[i]);
		}
		
		for(int i : arrayEnteros){
			System.out.println("El valor es: " + i);
		}
		
		//Otra manera de crear arrays
		//se puede poner los [] despues del nombre
		int arrayEnterosDirectamente[] = {1,2,3};
		for(int i : arrayEnterosDirectamente){
			System.out.println("El valor es: " + i);
		}
		System.out.println("===========================");
		System.out.println(arrayEnterosDirectamente);
	}
}
