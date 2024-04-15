package _04_ayuda_eclipse;

public class Persona {
	String nombre;
	int edad;
	double peso;
	boolean estaCasado;
	
	//Los IDEs en general nos ayudan mucho a la creación de código
	//En concreto Eclipse nos puede ayudar en la creación de los
	//contructores
	
	//Para crear este constructor 
	//-> boton derecho sobre donde queremos crearlo
	//-> seleccionamos "source"
	//-> seleccionarmos "Generate constructor using fields"
	//A continuación elegimos los atributos con los que queremos crear
	//el constructor
	public Persona(String nombre, int edad, double peso, boolean estaCasado) {
		super();//Esta palabra esta relacionada con la herencia
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estaCasado = estaCasado;
	}

	//podemos crear todos los constructores que queramos
	public Persona() {
		super();
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	//Sobreescribimos el método toString()
	/*
	public String toString() {
		return "Me llamos: " + this.nombre;
	}*/
	
	//Eclipse tambien nos ayuda en sobrescribir el método toString()
	//Para crear este método
	//-> boton derecho sobre donde queremos crearlo
	//-> seleccionamos "source"
	//-> seleccionarmos "Generate toString()"
	//A continuación elegimos los atributos con los que queremos crear
	//el método
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", estaCasado=" + estaCasado + "]";
	}	
	
}
