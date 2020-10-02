package _01_excepciones;

//Este ejemplo es una excepcion en tiempo de ejecucion
public class Main0 {
	public static void main(String[] args) {
		int nums[] = new int[4];
		try {
			System.out.println("Antes de que se genere la excepción.");
			// generar una excepcion de indice fuera de límites
			nums[7] = 10;
		} catch (ArrayIndexOutOfBoundsException exc) {
			// Capturando la excepción
			System.out.println("Índice fuera de los límites!");
		}
		System.out.println("Después de que se genere la excepción.");
	}

}
