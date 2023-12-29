package es.repaso;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainRepaso {

	public static void main(String[] args) {
		
		if(true){
			int numero1 = 5;
			System.out.println(numero1);System.out.println("sdafsdaf");
		}
		
		//Un objeto nacerá con "new"
		Persona p1 = new Persona();
		//Un objeto desaparecerá cuando no tenga ninguna referencia
		//apuntandole
		p1 = null;
		
		new Persona();
		System.gc();//da orden a la JVM de que pase el GC, pero 
					//JVM Hotspot no funciona muy bien. Os puede hacer caso o no
		
		Persona p2 = new Persona();
		p2.setNombre("Tony Stark");
		
		Persona p3 = p2;
		System.out.println(p3.getNombre());
		System.out.println(p2.getNombre());
		
		p2 = null;
		Persona p4 = p3;
		p3 = null;
		
		Persona p5  = new Persona();
		p5.setNombre("Tony Stark");
		
		System.out.println(p4 == p5);
		System.out.println(p4);
		System.out.println(p5);
		
		Persona p6 = new Persona();
		p6.setEdad(55);
		
		Persona p7 = new Persona();
		p7.setEdad(66);
		
		p6 = p7;
		
		p6.setEdad(44);//55 66 // 44 44 // 44 66
		System.out.println(p6.getEdad());
		System.out.println(p7.getEdad());
		
		Persona p8 = p7;
		Persona p9 = p6;
		Persona p10 = p8;
		p10.setEdad(100);
		System.out.println(p6.getEdad());//100 // 44
		System.out.println(p7.getEdad());//100 // 44
		System.out.println(p8.getEdad());//100 // 44
		
		//String en java es un tipo de objeto muy peculiar, porque tiene
		//varias caracteristicas que lo hacen muy especial
		//Los objetos String son !inmutables!
		//Un objeto es inmutable cuando nunca se puede cambiar el estado
		//del mismo.
		//El estado de un objeto es el valor de los atributos en un
		//instante de tiempo dado.
		Persona p11 = new Persona();
		p11.setNombre("illojuan");
		p11.setNombre("Rubius");
		
		PersonaInmutable pInmu = new PersonaInmutable("Ibai");
		
		//String es inmutable
		String s1 = "Paquito";
		s1 = "Manolo";
		s1 = s1 + " cabeza bolo";
		System.out.println(s1);
		String s2 = s1.replace('a', 'e');
		System.out.println(s2);
		
		String s3 = "ibai";
		String s4 = "ibai";
		System.out.println("--- Strings ---");
		System.out.println(s3 == s4);//true
		System.out.println(s3.equals(s4));//true
		
		System.out.println("--- Ibai ---");
		String s5 = new String("ibai");
		System.out.println(s3 == s5);//false
		System.out.println(s3.equals(s5));//true
		
		s5 = null;
		s3 = null;
		s4 = null;
		String s6 = "ibai";
		
		int n1 = 5;
		int n2 = 5;
		System.out.println(n1 == n2);//true
		
		//Arrays
		System.out.println("--- Arrays ----");
		List<Persona> listaPersonas = new LinkedList<>();
		Persona p13 = new Persona();
		
		
		listaPersonas.add(p13);
		p13.setNombre("El Zorro");
		System.out.println(listaPersonas);//El zorro
		//p13 = null;
		listaPersonas.remove(0);
		System.out.println(p13);
		p13 = null;
		
		int cp = 03456;
		System.out.println(cp);
		cp = 0xFFEE;//en base hexadecimal
		System.out.println(cp);
		cp = 0b101;//base binaria
		System.out.println(cp);
		
		Direccion d1 = null;
		//System.out.println(d1.getNombreVia());//nullpointer exception
		
		Persona p12 = new Persona();
		p12.setNombre("Steve Rogers");
		d1 = new Direccion();
		p12.setDireccion(d1);
		p12.getDireccion().setNombreVia("Avengers");
		System.out.println(p11.getDireccion().getNombreVia());
		
		System.out.println(d1.getNombreVia());//null // Avengers
		
		d1 = null;//he perdido el objeto direccion que cree en la linea 66?
		System.out.println(p11.getDireccion().getNombreVia());
		
		p11 = null;//he perdido algun objeto?
	}//Acaba el hilo principal de ejección del programa

}
