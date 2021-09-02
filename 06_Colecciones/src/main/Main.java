

package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

//lo ideal es ver por encima las diferentes estructuras de datos
//Array, Set etc, y cuando se vean herencia e interfaces volver
//para el tema de las comparaciones, metodo equals etc
public class Main {
	public static void main(String[] args) {
		List<String> listaStrings = new ArrayList<>();
		//listaStrings = new Vector<>();
		
		//el primer tio lo utiliza
		ArrayList<String> array2 = new ArrayList<>();
		metodoRecorreList(array2);
		//el segundo tio utiliza Vector
		Vector<String> vector = new Vector<>();
		
		metodoRecorreVector(vector);
		//
		metodoRecorre(array2);
		metodoRecorre(vector);
		
		//listaStrings.size();
		//
		//listaStrings.remove(1);
		
		
		Set<String> conjuntoStrings = new HashSet<>();
		//no puede haber elementos repetidos (a nivel de equal())
		conjuntoStrings.add("felix");
		conjuntoStrings.add("pepe");
		conjuntoStrings.add("felix");
		
		for(String s : conjuntoStrings){
			System.out.println(s);
		}
		
		Integer iObjeto = 5;//boxing
		int iPrimitivo = iObjeto;//unboxing
		System.out.println(iPrimitivo);
		
		
		Map<Integer, String> mapaStrings = new HashMap<>();
		mapaStrings.put(1, "felix");
		mapaStrings.put(2, "Maria");//new Integer(2);
		mapaStrings.put(3, "Ramon");//new Integer(3);
		//si ponemos una clave repetida, se sobreescribe
		mapaStrings.put(2, "Laura");
		
		String s = mapaStrings.get(2);//accedemos por clave
		System.out.println(s);
		s = mapaStrings.get(4);
		System.out.println(s);//null
		
		//
		listaStrings.add("Felix");
		listaStrings.add("Laura");
		listaStrings.add("Andres");
		listaStrings.add("Ramon");
		//contains compara segun el metodo equals
		if(listaStrings.contains("Laura")){
			System.out.println("Laura existe");
		}
		
	
		Collections.sort(listaStrings);//ordenamos una lista
		metodoRecorre(listaStrings);
		
		String[] array = {"Felix","Pepe"};
		System.out.println("=============");
		System.out.println(array);
		System.out.println(Arrays.asList(array));
		//un array no tiene sobrescrito el metodo toString, y un array
		//dinamico si que podemos hacerlo
	}
	
	//ESte metodo no esta aqui, esta en otra clase muy muy lejana
	public static void metodoRecorre(List<String> array){
		for(String s : array){
			System.out.println(s);
		}
	}
	
	//ESte metodo no esta aqui, esta en otra clase muy muy lejana
	public static void metodoRecorreList(ArrayList<String> array){
		for(String s : array){
			System.out.println(s);
		}
	}
	
	public static void metodoRecorreVector(Vector<String> vector){
		for(String s : vector){
			System.out.println(s);
		}
	}
}
