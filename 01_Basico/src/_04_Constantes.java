
public class _04_Constantes {

	public static void main(String[] args) {
		// Las constantes en java es un tipo especial de 'variable', el cual
		// el valor que almacenemos NO se puede cambiar durante todo el ciclo
		// de vida del programa
		
		// Las constantes pueden ser de cualquier tipo de datos
		
		// Las constantes en java se declaran con la palabra reservada
		// 'final'
		
		//Las constantes en java se suelen declarar en UpperSnakeCase
		//Ej: CONSTANTE_NUMERICA
		final double NUMERO_PI = 3.1416;
		
		System.out.println(NUMERO_PI);
		
		// Si intentamos cambiar el valor de una constante, nos dará
		// un error en tiempo de compilación
		// NUMERO_PI = 2.79; //Error

		final String TITULO_WEB = "Bienvenidos a  mi página web";
	}

}
