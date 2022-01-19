package entidad;

public class Calculo {

	/**
	 * Metodo que calcula si un numero es primo o no. Un numero es primo es
	 * cuando un numero es solamente divisible por si mismo y por la unidad
	 *  
	 * @param numero representa el numero a calcular si es primo o no
	 * @return <b>true</b> en caso de que el numero sea primo, <b>false</b> 
	 * en caso de que no
	 */
	public boolean calculoPrimo(int numero) {
		//Devuelvo true para que no me de error
		return true;
	}
	
	/**
	 * Metodo que calcula si un numero es primo o no. Un numero es primo es
	 * cuando un numero es solamente divisible por si mismo y por la unidad. 
	 * El numero debe de ser menor o igual que 1000
	 * 
	 * @param numero reprenta el numero a calcular si es primo o no
	 * @return false si no es primo o está fuera de rango (1000) true en caso
	 * de que sea primo
	 */
	public boolean calculoPrimoVersion1(int numero) {
		return true;
	}
	
	/**
	 * Metodo que calcula si un numero es primo o no. Un numero es primo es
	 * cuando un numero es solamente divisible por si mismo y por la unidad. 
	 * El numero debe de ser menor o igual que 1000
	 * 
	 * @param numero reprenta el numero a calcular si es primo o no
	 * @return 0 en caso de que el numero sea primo, 1 en caso de que el 
	 * numero NO primo y 2 en caso de que el numero sea superior a 1000
	 */
	public int calculoPrimoVersion2(int numero) {
		return 0;
	}
}
