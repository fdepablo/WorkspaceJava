package _05_listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import _04_basico.vehiculos.Coche;

public class MainListas {

	public static void main(String[] args) {
		//Java tiene ya MUCHAS interfaces predifinadas
		//Una de las más importante es la interfaz "List"
		
		//En este interfaz se define los métodos que tienen
		//que implmentar TODAS las clases que implementen
		//la interfaz "List", las más importantes son:
		
		//La clase ArrayList y la clase LinkedList
		//La implementacion de ArrayList es una implementación
		//que es muy buena cuando queremos recorrer la lista
		//muchas veces pero no suele cambiar de tamaño
		
		//La implementación LinkedList es muy buena cuando
		//la lista cambia mucho de tamaño pero en cambio 
		//no la recorremos demasiado
		
		List<Coche> listaArrayCoches = new ArrayList<>();
		listaArrayCoches.add(new Coche());
		
		LinkedList<Coche> listaLinkedCoches = new LinkedList<Coche>();
		//como ambas lista implemtan la interfaz list tenemos los mismos
		//métodos, por lo tanto para nosotros lo programadores NO
		//habrá diferencia de como vamos a usar ambas listas
		listaLinkedCoches.add(new Coche());
		recorrerLista(listaLinkedCoches);
		recorrerLista(listaArrayCoches);
		
		//Creamos la persona con sus coches
		Persona p = new Persona();
		p.setNombre("Guillermo cumpleañero");
		Coche c1 = new Coche();
		Coche c2 = new Coche();
		List<Coche> listaCoches = new ArrayList<>();
		listaArrayCoches.add(c1);
		listaArrayCoches.add(c2);
		p.setListaCoches(listaCoches);
		
		Almacen<Coche> aCoche = new Almacen<>();
		aCoche.setDato(c2);
		
		Almacen<Persona> aPersona = new Almacen<Persona>();
		
	}
	
	public static void recorrerLista(List<Coche> lista) {
		System.out.println(lista);
	}

}
