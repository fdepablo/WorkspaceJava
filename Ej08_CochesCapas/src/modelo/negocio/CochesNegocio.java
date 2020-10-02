package modelo.negocio;

import modelo.entidades.Coche;
import modelo.persistencia.CochesPersistencia;

public class CochesNegocio {
	
	/**
	 * 
	 * @param coche
	 * @return 0 en caso de que haya ido bien, 1 en caso de que este el array
	 * lleno y 2 en caso de que la matricula sea mayor que 10
	 */
	public int addCoche(Coche coche) {
		if(coche.getMatricula().length() == 7){
			CochesPersistencia cp = new CochesPersistencia();
			return cp.addCoche(coche);
		}else {
			return 2;
		}
	}
	
	public Coche[] getListaCoches() {
		return new CochesPersistencia().getListaCoches();
	}
}
