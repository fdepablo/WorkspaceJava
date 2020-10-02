package main;

import java.util.Comparator;

public class CompararPersonaPorNombre implements Comparator<Persona> {

	//si devolvemos negativo quiere decir que o1 es menor que o2
	//si devolvemos 0 que o1 es igual que o2
	//si devolvemos positivo quiere decir que o1 es mayor que o2
	@Override
	public int compare(Persona o1, Persona o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
