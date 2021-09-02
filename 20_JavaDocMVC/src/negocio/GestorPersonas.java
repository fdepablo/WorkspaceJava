package negocio;

import beans.Persona;
import persistencia.DaoPersonas;

/**
 * 
 * Esta clase sirve para aplicar toda la logica de negocio de la clase persona
 * 
 * @author Felix de Pablo
 * @see Persona
 *
 */
public class GestorPersonas {
	
	/**
	 * Metodo que sirve para dar de alta una persona en nuestra aplicación, la persistencia
	 * asignará el id de la persona
	 * 
	 * @author Felix de Pablo
	 * @since 26/11/2018
	 * @param p representa la persona a dar de alta
	 * @return 2 en caso de que el nombre del usuario sea mayor de 10 caracteres, 0 en 
	 * caso de que no haya habido problema, y 1 en caso de que no se haya podido guardar
	 * por motivos de espacio
	 */
	public int altaPersona(Persona p) {
		//no admito nombres mayores que 10 en mi aplicacion
		if(p.getNombre().length() <= 10) {//esta seria mi regla de negocio o requisito funcional
			DaoPersonas daoPersonas = new DaoPersonas();
			return daoPersonas.altaPersonas(p);
		}else {
			return 2;
		}
	}
	
	/**
	 * Metodo que accede a la persistencia y devuelve una lista con todas las personas que hay
	 * dadas de alta en ella
	 * 
	 * @author Felix de Pablo
	 * @since 14/11/2019
	 * @return la lista con las personas
	 */
	public Persona[] listarPersona() {
		return new DaoPersonas().listarPersonas();
	}
	
	
	
	//pequeño ejemplo si tuvieramos que devolver excepciones
	/*
	/**
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * @throws ArithmeticException
	 *
	public int dividir(int d1, int d2) throws ArithmeticException{
		return d1 / d2;
	}*/
}
