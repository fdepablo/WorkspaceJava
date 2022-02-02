
public class Main {
	public static void main(String[] args) {
		Persona p = new Persona();
		p.setNombre("Steve roger");
		p.setEdad(40);
		
		//
		Persona p2 = p;
		p2.setEdad(55);
		
		System.out.println(p2.getEdad());// 55 55    40 55
		System.out.println(p.getEdad());
		
		Persona p3 = p;
		System.out.println(p3.getNombre());
		
		cambiarNombre(p3);
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p3);
		
		p.setNombre("Natasha romanov");
		
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p3);
		
		GestorPersona gp = new GestorPersona();
		boolean resultado = gp.validarNombre(p);
		System.out.println(resultado);
		
		p2 = new Persona();
	}
	
	public static void cambiarNombre(Persona p4) {
		p4.setNombre("Tony Stark");
	}
}
