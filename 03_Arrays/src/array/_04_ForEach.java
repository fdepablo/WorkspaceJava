package array;

public class _04_ForEach {

	public static void main(String[] args) {
		// Hay una manera mas sencilla de recorrer arrays sin tener 
		// que usar el for normal, que es el llamado "for-each"
		String[] blackWidow = new String[4];
		blackWidow[0] = "Natasha";
		blackWidow[1] = "Romanoff";
		blackWidow[2] = "+00459876543";
		blackWidow[3] = "Molotov";
		
		//La estructura es la siguiente:
		//for(VARIABLE : ARRAY){}
		//VARIABLE: Va a contener el VALOR de cada una de las posiciones del array
		//para cada una de las iteraciones. Debe de ser del mismo tipo que el array
		//(de momento)
		for(String s : blackWidow) {
			System.out.println(s);
		}
		
		//Esta manera tiene ventajas e incovenientes.
		//VENTAJAS
		//1- Es muy sencillo de recorrer completamente un array por todas sus posiciones
		//o indices
		//2- Es más rápido de escribir
		
		//INCONVENIENTES
		//1- No tenemos acceso al indice o a una posición concreta
		//2- No podemos alterar la manera de recorrere el array. Por ejemplo, 
		//no podemos acceder solamente a los pares
		
		//Podemos utilizar variables auxiliares para controlar el indice
		//de manera artificial
		int posicion = 1;
		for(String s : blackWidow) {
			System.out.println(posicion + "-" + s);
			posicion++;
		}
	}

}
