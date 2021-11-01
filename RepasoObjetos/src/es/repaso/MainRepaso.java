package es.repaso;

public class MainRepaso {

	public static void main(String[] args) {
		System.out.println("arrancando");
		//El ciclo de vida de un objeto en java es:
		//1- nace cuando hacemos un new del objeto
		//2- y muere cuando no haya ninguna referencia apuntandolo ojo!!!
		
		//La siguiente pregunta sería cuanto tiempo vive una referencia en stack
		//Una referencia vive desde que se crea hasta que sale del bloque donde
		//se creo
		new Persona();
		
		Persona p = new Persona();
		p.setNombre("Tony Stark");
		p.setEdad(43);
		p.setPeso(85.6);
		p = null;
		
		{
			Persona p1 = new Persona();
		}
		
		if(true) {
			Persona p2 = new Persona();
		}
		
		crearPersona();
		crearPersona();
		crearPersona();
		
		Persona p3 = crearPersona2();
		
		Persona p4 = p3;
		
		p4.setEdad(55);
		
		System.out.println(p3.getEdad());//55 90 55 55 90 55
		System.out.println(p4.getEdad());
		
		p4 = new Persona();
		p3.setEdad(66);
		
		System.out.println(p3.getEdad());//66 66 66 0
		System.out.println(p4.getEdad());
		
		Persona p5 = new Persona();
		p5.setNombre("Peter Parker");
		p5.setEdad(17);
		Direccion direccion = new Direccion();
		//Inyectamos la dependecia por setter
		p5.setDireccion(direccion);
		p5.getDireccion().setNombreVia("Calle de la tia ross");
		p5.getDireccion().setCp(28345);
		System.out.println(p5);
		
		direccion.setNombreVia("Howards");
		
		System.out.println(p5);
		
		p5.getDireccion().setNombreVia("Tatuin");
		System.out.println(direccion.getNombreVia());
		
		Direccion direcion2 = new Direccion();
		direcion2.setNombreVia("Segovia");
		
		System.out.println(p5.getDireccion().getNombreVia());
		
		direccion = new Direccion();
		
		var s = new Persona();
	}//fin programa
	
	public static void crearPersona() {
		Persona p1 = new Persona();
		p1.setNombre("Tony Stark");
		p1.setEdad(43);
		p1.setPeso(85.6);
	}
	
	public static Persona crearPersona2() {
		Persona p1 = new Persona();
		p1.setNombre("Steve Rogers");
		p1.setEdad(90);
		p1.setPeso(91);
		return p1;
	}

}
