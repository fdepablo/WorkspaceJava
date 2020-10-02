package entidad;

/**
 * Esta clase realiza las 4 operaciones basicas, sumar, restar, multiplicar y dividir
 * @author Felix de Pablo
 * @since 13/01/2020
 * @version 1.0
 *
 */
public class Matematicas {
	
	/**
	 * Este metodo suma dos numeros enteros
	 * 
	 * @param n1 representa el primer numero a sumar
	 * @param n2 representa el segundo numero a sumar
	 * @return la suma de ambos numeros
	 */
	public int sumar(int n1, int n2) {
		return n1 + n2;//sumaros n1 + n2
	}
	
	/**
	 * Este metodo resta dos numeros enteros
	 * 
	 * @param n1 represente el primero numero a restar
	 * @param n2 representa el segundo numeor a restar
	 * @return la resta de ambos numeros, puede ser <b>negativo</b> en caso de que n1 mayor n2
	 */
	public int restar(int n1, int n2) {
		return n1 - n2;
	}
	
}
