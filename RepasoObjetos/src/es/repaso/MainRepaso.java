package es.repaso;

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
		
		int cp = 03456;
		System.out.println(cp);
		cp = 0xFFEE;//en base hexadecimal
		System.out.println(cp);
		cp = 0b101;//base binaria
		System.out.println(cp);
		
		Direccion d1 = null;
		//System.out.println(d1.getNombreVia());//nullpointer exception
		
		Persona p11 = new Persona();
		p11.setNombre("Steve Rogers");
		d1 = new Direccion();
		p11.setDireccion(d1);
		p11.getDireccion().setNombreVia("Avengers");
		System.out.println(p11.getDireccion().getNombreVia());
		
		System.out.println(d1.getNombreVia());//null // Avengers
		
		d1 = null;//he perdido el objeto direccion que cree en la linea 66?
		System.out.println(p11.getDireccion().getNombreVia());
		
		p11 = null;//he perdido algun objeto?
	}//Acaba el hilo principal de ejección del programa

}
