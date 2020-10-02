package main;

import java.util.ArrayList;
import java.util.List;

import entidades.Coche;
import negocio.CochesSingleton;

public class Main {

	public static List<Coche> listaCoches = new ArrayList<>();
	
	public static void main(String[] args) {
		Object referencia = new Object();//Tiene que ser utilizado en las otras clases
		CochesSingleton cs = CochesSingleton.getInstance();
		cs.addCoche(new Coche("dhfkdsf","REnault"));
		cs.addCoche(new Coche("6758-rty", "Peugeot"));
		System.out.println(cs.getListaCoches());
		
		OtraClase otraClase = new OtraClase();
		otraClase.otroMetodo(referencia);
		
	}

}
