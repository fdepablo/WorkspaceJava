package entidad;


public class MainPersona {

	public static void main(String[] args) {
		Persona p1 = new Persona("Steve", 44 , 2);
		System.out.println(p1);
		p1.setNombre("Pe");
		System.out.println(p1);//Imprime ""
		p1.setNombre("Peter");
		System.out.println(p1);
		
		p1.caminar(10);
		
		Persona p2 = p1.copiarPersona();
		System.out.println(p1);
		System.out.println(p2);
		p1.setEdad(89);
		System.out.println(p1);
		System.out.println(p2);
		
		Persona p3 = p1.personaMayor(p2);
		System.out.println(p3);
		
		System.out.println(p3.calcularDistancia(30));
		System.out.println(p3.calcularDistancia(-9));
	}

}
