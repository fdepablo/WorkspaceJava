package _02_constructores;

public class _01_MainConstructores {

	public static void main(String[] args) {
		// Siempre tendremos que crear un objeto a traves de
		// un constructor
		Persona p = new Persona();
		System.out.println(p.edad);
		
		Persona p2 = new Persona();
		System.out.println(p2.edad);
		
		//VAmos a invocar el constructor con parametros
		Persona p3 = new Persona("Tony Stark", 45, 90.67, true);
		
		System.out.println(p3.nombre);
		System.out.println(p3.edad);
		System.out.println(p3.peso);
		System.out.println(p3.estaCasado);
		
		Persona p4 = new Persona("Peter Parker", 18, 75.89, false);
		
		System.out.println(p4.nombre);
		System.out.println(p4.edad);
		System.out.println(p4.peso);
		System.out.println(p4.estaCasado);
		
		Persona p5 = new Persona("Natasha");
		System.out.println(p5.nombre);
		System.out.println(p5.edad);
		System.out.println(p5.peso);
		System.out.println(p5.estaCasado);
	}

}
