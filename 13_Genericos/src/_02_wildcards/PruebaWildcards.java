package _02_wildcards;

import java.util.ArrayList;
import java.util.List;

import entidades.Mastin;
import entidades.Perro;

public class PruebaWildcards {
	//Wildcards o Comodines
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Perro> listaPerro = new ArrayList<>();
		Mastin mastin1 = new Mastin();
		mastin1.setNombre("rufo");
		Mastin mastin2 = new Mastin();
		mastin2.setNombre("daisy");
		listaPerro.add(mastin1);
		listaPerro.add(mastin2);
		
		//Esto lo podemos hacer sin problema
		imprimirLista(listaPerro);
		
		//Pero esto dara problemas
		List<Mastin> listaMastin = new ArrayList<>();
		listaMastin.add(mastin1);
		listaMastin.add(mastin2);
		//esto da error ya que solamente puede ser
		//de perros, y no importa que mastin extienda de perro
		//imprimirLista(listaMastin);
		
		System.out.println("---------- Wildcards ----------");
		//podemos usar el otro metodo sin problema para ambas listas
		imprimirListaWildcard(listaPerro);
		imprimirListaWildcard(listaMastin);
	}

	public static void imprimirLista(List<Perro> lista){
		for(Object elemento : lista){
			System.out.println(elemento);
		}		
	}
	
	//la ? le estamos diciendo que puede ser de cualquier tipo
	//podemos poner extends si queremos limitarlo a un tipo de
	//clase
	public static void imprimirListaWildcard(List<?> lista){
		for(Object elemento : lista){
			System.out.println(elemento);
		}		
	}
}
