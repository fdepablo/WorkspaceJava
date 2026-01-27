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
	
	//En java existe el concepto de Firma de método o de función
	//La firma de un método es lo que hace que Java distinga unívocamente
	//un método de otro.
	
	//En Java la firma de un método esta compuesto de:
	//1. El nombre de la función
	//2. El número de parámetros de entrada de una función
	//3. El tipo de parámetros de entrada de una función
	//OJO! El parámetro de salida no pertenece a la firma de un método
	
	//El siguiente método daria error, porque tiene la MISMA FIRMA que la
	//el método presentarse() de arriba. Para Java ambos métodos son iguales
	//por lo que si lo queremos llamar no sabría cual invocar
	
	/*
	public void presentarse() {
		System.out.println("----------------------------");
	}*/
	
	//Creamos otro método que se llame igual, PERO cambiamos el número
	//de parámetros de entrada. Por lo tanto, la firma es diferente y 
	//no da error
	public void presentarse(boolean mostrarEstaCasado) {
		System.out.println("Mi nombre es: " + this.nombre);
		System.out.println("Mi edad es: " + edad);
		System.out.println("Mi peso es: " + this.peso + " Kg");
		if(mostrarEstaCasado) {
			System.out.println("Estoy casado? : " + this.estaCasado);
		}
	}
	
	//Ahora cambiamos la firma del método, pero esta vez variando el TIPO 
	//de parámetros de entrada
	public void presentarse(int numeroDeVeces) {
		for (int i = 1; i <= numeroDeVeces; i++) {
			System.out.println("Presentación nº " + i);
			System.out.println("Mi nombre es: " + this.nombre);
			System.out.println("Mi edad es: " + edad);
			System.out.println("Mi peso es: " + this.peso + " Kg");
			System.out.println("Estoy casado? : " + this.estaCasado);
		}		
	}
	
	//Concepto de SOBRECARGA en POO.
	//En java sobrecargamos una función o un método cuando 
	//dos o mas método o funciones tienen el mismo nombre PERO distinta firma, 
	//es decir, cambia el número de parametros de entrada, cambia el tipo 
	//de parámetros de entrada o las dos cosas.
	
	//De esta manera el método presentarse() de arriba esta sobrecargado.
	
	//El siguiente método daría error en tiempo de compilación porque
	//tiene la misma firma que el método de arriba. El parámetro de
	//salida NO pertenece a la firma de un método, por lo tanto
	//Java no tiene manera de distinguirlos
	
	/*
	public String presentarse(int numeroDeVeces) {
		return this.nombre + " " + this.edad + " " + this.peso + " " + this.estaCasado;
	}*/
}
