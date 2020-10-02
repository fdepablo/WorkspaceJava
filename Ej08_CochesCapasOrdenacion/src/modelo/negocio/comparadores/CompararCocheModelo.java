package modelo.negocio.comparadores;

import java.util.Comparator;

import modelo.entidades.Coche;

public class CompararCocheModelo implements Comparator<Coche> {

	@Override
	public int compare(Coche o1, Coche o2) {
		return o1.getModelo().compareTo(o2.getModelo());
	}

}
