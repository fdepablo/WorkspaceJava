package _01_genericos;

import java.util.ArrayList;
import java.util.List;

import entidades.Mastin;
import entidades.Perro;
import entidades.Persona;

public class PruebaGenericos {

	public static void main(String[] args) {
		Almacen<Persona> almacen = new Almacen<Persona>();
		
		Persona p1 = new Persona();
		p1.setDni("52887766s");
		p1.setEdad(25);
		p1.setPeso(78.2);
		
		Persona p2 = new Persona();
		p2.setDni("52887766s");
		p2.setEdad(25);
		p2.setPeso(78.2);
		
		System.out.println(p1.equals(p2));
		
		almacen.setValorAlmacenado(p1);
		Persona p3 = almacen.getValorAlmacenado();
		System.out.println(p2);
		System.out.println(p3);
		
		String s = "Valor";
		
		Almacen<String> almacenStrings = new Almacen<String>();
		almacenStrings.setValorAlmacenado(s);
		
		//podemos crear un almacen sin usar genericos
		Almacen almacenGenerico = new Almacen();
		almacenGenerico.setValorAlmacenado(p1);
		almacenGenerico.setValorAlmacenado(s);
		
		//peroo tenemos que castear el valor para usarlo
		String s2 = (String)almacenGenerico.getValorAlmacenado();
		p3 = (Persona)almacenGenerico.getValorAlmacenado();
		System.out.println(s2);
		
		// Esto podemos probarlo si el almacen el generico lo extendemos de Perro
		Almacen<Perro> almacenPerros = new Almacen<>();
		Almacen<Mastin> almacenMastines = new Almacen<>();
		// Pero entonces el almacen de personas deberia de dar error
		
		// Tambien podemos usar genericos en los metodos sin necesidad
		//de que esten dentro de clases genericas
		System.out.println("-----------------------------------");
		System.out.println("Buscamos en un array de personas");
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		Persona personaResultado = buscarElemento(listaPersonas, p2);
		if(personaResultado != null){
			System.out.println("Si esta la persona que estamos buscando");
			System.out.println(personaResultado);
		}
		
		List<String> listaStrings = new ArrayList<>();
		listaStrings.add(s2);
		listaStrings.add("Valor 2");
		String stringResultado = buscarElemento(listaStrings, "valor 3");
		if(stringResultado != null){
			System.out.println("Encontramos el string");
		}else{
			System.out.println("No encontramos el string");
		}		

	}

	/**
	 * 
	 * @param array
	 * @param elementoBuscar
	 * @return objeto pasado si esta en el array, null en caso de que
	 * no se encuentre
	 */
	public static <E> E buscarElemento(List<E> lista, E elementoBuscar){
		E resultado = null;
		for(E elemento : lista){
			if(elemento.equals(elementoBuscar)){
				resultado = elementoBuscar;
				break;
			}
		}		
		return resultado;
	}
}
