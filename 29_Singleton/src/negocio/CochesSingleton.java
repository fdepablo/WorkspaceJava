package negocio;

import java.util.ArrayList;
import java.util.List;

import entidades.Coche;

public class CochesSingleton {
	
	private List<Coche> listaCoches = new ArrayList<>();
	//Empieza el singleton
	private static CochesSingleton instance = null;
	
	private CochesSingleton() {
		super();
	}
	
	public static CochesSingleton getInstance() {
		if(instance == null) {//me garantiza que solo se crea el objeto una vez
			instance = new CochesSingleton();
		}
		return instance;
	}
	//acaba el singleton
	public void addCoche(Coche coche) {
		listaCoches.add(coche);
	}

	public List<Coche> getListaCoches() {
		return listaCoches;
	}

	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	
	
	
}
