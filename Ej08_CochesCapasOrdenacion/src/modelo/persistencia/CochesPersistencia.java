package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.entidades.Coche;

/**
 * 
 * Esta clase el objetivo es dar persistencia en memoria (concretamente
 * un array) para la clase Coche
 * 
 * @author Felix de Pablo lobo
 *
 */
public class CochesPersistencia {

	private static List<Coche> arrayCoches = new ArrayList<>();
	private static final int NUMERO_COCHES_MAX = 10;
	
	/**
	 * Este metodo add un coche al array devolviendo un valor
	 * por si ha habido algun error
	 *  
	 * @param coche el coche a insertar que no sea nulo
	 * @return 0 en caso de que haya ido bien, 1 en caso de que
	 * el array este lleno
	 */
	public int addCoche(Coche coche) {
		if(arrayCoches.size() < NUMERO_COCHES_MAX) {
			arrayCoches.add(coche);
			return 0;
		}else {
			return 1;
		}
	}
	
	public List<Coche> getListaCoches() {
		return arrayCoches;
	}
	
}
