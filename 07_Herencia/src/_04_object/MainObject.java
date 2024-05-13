package _04_object;

import java.util.ArrayList;

public class MainObject {

	public static void main(String[] args) {
		//Con una referencia de tipo Object podemos apuntar a CUALQUIER 
		//Object
		Object o = new Persona();
		o = new Alumno();
		o = new ArrayList<Docente>();
		o = new int[5];
		o = 5;
		
		//Esto sería una lista de objeto generica
		//Las listas en java hasta la versión 1.5 eran así
		ArrayList<Object> listaObjetos = new ArrayList<Object>();
		listaObjetos.add(new Persona());
		listaObjetos.add(new Alumno());
		listaObjetos.add(new ArrayList<Docente>());
		listaObjetos.add(5);
		
		//Algunos métodos de la clase object
		Persona p1 = new Persona();
		p1.setNombre("Anton");
		p1.setEdad(25);

		System.out.println(p1.toString());
		o = p1;
		System.out.println(o.toString());//Polimorfismo
		//Siempre se va a ejecutar el método del objeto al que 
		//esttamos apuntando, no importa la referencia, es un 
		//mero apuntador
		
		Persona p2 = new Persona();
		p2.setNombre("Anton");
		p2.setEdad(25);
		
		if(p1 == p2) {
			System.out.println("==: Son iguales");
		}else {
			System.out.println("==: Son diferentes");
		}
		
		if(p1.equals(p2)) {
			System.out.println("equals() -> Son iguales");
		}else {
			System.out.println("equals() -> Son diferentes");
		}
		
		//Para java 2 objetos son iguales SOLAMENTE
		//cuando ambas referencias apuntan al mismo objeto
		/*
		p1 = p2;
		if(p1.equals(p2)) {
			System.out.println("Son iguales");
		}else {
			System.out.println("Son diferentes");
		}*/
		
		//lo que tendriamos que hacer para comparar en un momento
		//dado, es por el valor de los atributos
		//Si tenemos muchos atributos, se complica mucho la faena
		
		//Para comprar objetos por atributos, se suele sobreescribir
		//el método equeals y el método hashCode(), ambos van de la mano
		
	}

}
