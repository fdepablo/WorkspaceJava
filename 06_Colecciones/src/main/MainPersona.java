package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainPersona {
	public static void main(String[] args) {
		Persona p1 = new Persona();
		p1.setNombre("Felix");
		p1.setEdad(39);
		
		
		Persona p2 = new Persona();
		p2.setNombre("Maria");
		p2.setEdad(29);
		
		Persona p3 = new Persona();
		p3.setNombre("Felix");
		p3.setEdad(39);
		
		List<Persona> listaPersonas = new ArrayList<>();
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		System.out.println(listaPersonas.get(0));
		
		Set<Persona> conjuntoPersonas = new HashSet<>();
		conjuntoPersonas.addAll(listaPersonas);
		
		recorrer(listaPersonas);
		System.out.println("-----------");
		recorrer(conjuntoPersonas);
		
		Persona p4 = new Persona();
		p4.setNombre("Felix");
		p4.setEdad(39);
		
		if(listaPersonas.contains(p4)){
			System.out.println("La contiene la persona felix");
		}else{
			System.out.println("No la contine la persona felix");
		}
		
		System.out.println(p1.equals(p3));
		System.out.println("-----------");
		Collections.sort(listaPersonas);
		recorrer(listaPersonas);
		System.out.println("-----------");
		Collections.sort(listaPersonas,new CompararPersonaPorNombre());
		recorrer(listaPersonas);
		
		//HashMaps
	}
	
	public static void recorrer(Collection<Persona> coleccion){
		for(Persona persona : coleccion){
			System.out.println(persona);
		}
	}
}
