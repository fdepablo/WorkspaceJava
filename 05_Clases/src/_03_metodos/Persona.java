package _03_metodos;

// Dentro de una clase, además de atributos, pueden realizar funcionalidades
// que se declaran como "METODOS". En POO, a las funciones se le llaman
// "métodos". Siguen las mismas reglas de las funciones que vimos en 
// el ejemplo "02_IntroduccionJava".

// Para crear un método en java, se crea igual que una función pero
// se quita la palabra "static". Cuando creamos un método, el método
// esta dentro del un objeto, si creamos una función (un método con
// la palabra "static"), la función estará fuera del objeto.

public class Persona {
	String nombre;
	int edad;
	double peso;
	boolean estaCasado;

	public Persona() {

	}

	public Persona(String nombre, int edad, double peso, boolean estaCasado) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estaCasado = estaCasado;
	}
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}
	
	// Los métodos van dentro de la clase, y normalmente se ponen despues
	// de los atributos y los constructores
	
	public void presentarse() {
		// "this" es la refrencia al propio objeto
		System.out.println("Mi nombre es: " + this.nombre);
		//int edad = 0;
		System.out.println("Mi edad es: " + edad);
		//podemos poner la "edad" SIN "this" siempre y cuando
		// no se haya declarado una variable o un parametro de
		// entrada con el nombre "edad"
		System.out.println("Mi peso es: " + this.peso + " Kg");
		System.out.println("Estoy casado? : " + this.estaCasado);
	}
	
	public void ponerEdad(int edad) {
		if(edad < 0) {
			this.edad = 0;
		}else {
			this.edad = edad;
		}		
	}
	
	public double obtenerPesoEnLibras() {
		double pesoEnLibras = 0;
		pesoEnLibras = this.peso * 2.205;
		return pesoEnLibras;
	}

}
