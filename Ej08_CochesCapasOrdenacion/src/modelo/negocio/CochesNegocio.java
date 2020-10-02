package modelo.negocio;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.entidades.Coche;
import modelo.persistencia.CochesPersistencia;

public class CochesNegocio {
	
	/**
	 * 
	 * @param coche
	 * @return 0 en caso de que haya ido bien, 1 en caso de que este el array
	 * lleno y 2 en caso de que la matricula diferente que 7
	 * 3 en caso de que la matricula este repetida
	 */
	public int addCoche(Coche coche) {
		List<Coche> listaCoche = getListaCoches();
		if(!listaCoche.contains(coche)) {//porque el equals este sobrescrito
			if(coche.getMatricula().length() == 7){
				CochesPersistencia cp = new CochesPersistencia();
				return cp.addCoche(coche);
			}else {
				return 2;
			}
		}else {
			return 3;
		}
	}
	
	public List<Coche> getListaCoches() {
		return new CochesPersistencia().getListaCoches();
	}
	
	public List<Coche> getListaCochesOrdenada(Comparator<Coche> comparador){
		List<Coche> listaCoches = getListaCoches();
		//si el comparador es null, ordena por el metodo natural de ordenación
		Collections.sort(listaCoches, comparador);	
		return listaCoches;
	}
	
	public Coche buscarPorMatricula(String matricula) {
		List<Coche> listaCoches = getListaCoches();
		Coche cocheEncontrado = null;
		for(Coche coche : listaCoches) {
			if(coche.getMatricula().equals(matricula)) {
				cocheEncontrado = coche;
				break;
			}
		}
		
		return cocheEncontrado;
	}
	
}












