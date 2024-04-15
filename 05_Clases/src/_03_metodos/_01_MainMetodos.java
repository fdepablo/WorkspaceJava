package _03_metodos;

public class _01_MainMetodos {

	public static void main(String[] args) {
		//Vamos a crear objetos y a ejecutar su método "presentarse()"
		Persona p1 = new Persona("tony",45,90,false);
		//Para invocar un método normalmente necesitamos una referencia
		//al objeto, y pondremos un "." para acceder al método
		p1.presentarse();
		//ver dibujo "_03_metodos_01_primer_objeto.jpg"
		
		p1 = new Persona("natasha",35,70,true);
		p1.presentarse();
		//ver dibujo "_03_metodos_02_segundo_objeto.jpg"
		
		p1.ponerEdad(50);
		p1.presentarse();
		
		p1.ponerEdad(-89);
		p1.presentarse();
		System.out.println("El peso en libras es: " + p1.obtenerPesoEnLibras());
		p1 = new Persona("Hulk",40,635,false);
		System.out.println(p1.obtenerPesoEnLibras());
		p1.presentarse();
	}

}
