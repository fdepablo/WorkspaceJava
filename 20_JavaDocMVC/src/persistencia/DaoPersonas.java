package persistencia;

import beans.Persona;

/**
 * Esta clase es la encargada de dar de alta en un array una persona. Cuando el programa
 * se pare se perderan las personas guardadas en el
 * @author Lucia 
 *
 */
public class DaoPersonas {
	//constante que lleva el numero maximo de persona que podemos meter en nuestra aplicación
	private static final int NUMERO_MAX_PERSONAS = 3;
	//array donde guardaremos las personas
	private static Persona[] arrayPersonas = new Persona[NUMERO_MAX_PERSONAS];
	//variable que lleva el contador de las personas en el array, tambien sirve para
	//asingar los ids de las personas
	private static int numeroPersonas = 0;
	
	/**
	 * Dar de alta una persona en el array, el id sera asignado secuencialmente
	 * @author Felix
	 * @param p representa la persona a dar de alta
	 * @return 0 en caso de que la persona se haya dado de alta, 1 en caso de que no haya
	 * sitio en el array
	 */
	public int altaPersonas(Persona p) {
		if(numeroPersonas < NUMERO_MAX_PERSONAS) {
			//asignamos un id a la persona
			p.setId(numeroPersonas);
			//metemos la persona en el array en su posicion
			arrayPersonas[numeroPersonas] = p;
			numeroPersonas++;
			return 0;
		}else {
			return 1;
		}
	}
	
	/**
	 * Devuelve el array con todas las personas
	 * 
	 * @author Felix
	 * @return el array con las personas
	 * @since 14/11/2019
	 */
	public Persona[] listarPersonas() {
		return arrayPersonas;
	}
}
