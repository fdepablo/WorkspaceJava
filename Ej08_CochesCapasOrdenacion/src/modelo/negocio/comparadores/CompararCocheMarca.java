package modelo.negocio.comparadores;

import java.util.Comparator;

import modelo.entidades.Coche;

public class CompararCocheMarca implements Comparator<Coche> {

	@Override
	public int compare(Coche o1, Coche o2) {
		return o1.getMarca().compareTo(o2.getMarca());
	}

}
