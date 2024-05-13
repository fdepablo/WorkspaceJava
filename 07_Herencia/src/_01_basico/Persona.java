package _01_basico;

/**
 * La herencia es una de las propiedades más importante que podemos encontrar
 * en POO. Mediante la herencia podemos hacer que una clase tenga todos
 * los atributos y métodos de otra. La clase de la cual heredamos se llama
 * clase "Padre" y la clase que hereda se llama clase "Hija". Es decir,
 * la clase "Hija" tendrá todos los atributos y métodos de la clase "Padre"
 * 
 * Existe el concepto de "Herencia multiple", esto se da cuando una clase
 * hija tiene más de un padre, por ejemplo, dos padres. En Java la herencia
 * multiple NO se implementa directamente (se puedo hacer con Interface, que
 * veremos más adelante)
 * 
 */
public class Persona {
	public String nombre;
	public int edad;
	
	public void presentarse() {
		System.out.println("Hola soy una Persona y me llamo: " + nombre);
	}
}
