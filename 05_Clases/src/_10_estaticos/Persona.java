package _10_estaticos;

public class Persona {
	//No tendría mucho sentido crear el nombre estático
	//ya que el atributo nombre sería compartido
	//por todos los objetos, con lo que solamente
	//podriamos tener un valor guardado
	public static String nombre;
	public int edad;
	
	//Si tendría sentido tener el numero de personas
	//como estático ya que así tendríamos localizado
	//dicho número en un único atributo compartido
	//por todos los objetos
	public static int numeroPersonas;
	
	public Persona() {
		super();
	}
	
	//A los métodos dinámicos se accede a traves de la 
	//referencia
	public boolean esMayorEdad() {
		System.out.println("El numero personas " + numeroPersonas);
		if(this.edad >= 18) {
			return true;
		}else {
			return false;
		}
	}
	
	//A los métodos estaticos se accede a través de la clase
	//Si estamos dentro de la clase, podemos omitirla
	public static void imprimirNumeroPersonas() {
		System.out.println(numeroPersonas);
		//En los métodos estáticos no existe "this", porque
		//"this" es una referencia al propio objeto, y
		//la parte estática no pertenece al objeto
		//this.edad;
		//edad
	}
	
	//Para imprimir un atributo dinámico en un método dinámico
	//no hay problema, porque el objeto tiene el propio
	//atributo
	public void imprimirEdadDinamico() {
		System.out.println(this.edad);
	}
	
	//Para imprimir un atributo dinámico dentro de un 
	//método estatico, no podemos acceder a el
	//Debemos de pasarle el objeto que tenga el atributo
	public static void imprimirEdadEstatico(Persona p) {
		//System.out.println(this.edad);
		//System.out.println(edad);
		System.out.println(p.edad);
		System.out.println("Este método lo ha ejecutado el programa " 
				+ _01_MainEstaticos.NOMBRE_DEL_PROGRAMA);
		
	}
	
	
}
