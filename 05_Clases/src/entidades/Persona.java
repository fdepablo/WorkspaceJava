


package entidades;

public class Persona {
	//Normalmente la primera parte se ponen los atributos
	public String nombre;
	public int edad;
	public double peso;
	private String dni;
	private int posicion;
	private Direccion direccion;
	
	private static int numeroPersonas;
		
	//Constructuores
	public Persona(){
		super();//metodo invoca al constructor padre (Object)
		setNumeroPersonas(getNumeroPersonas() + 1);
	}
	
	public Persona(String nombre, 
			int edad, 
			double peso, 
			String dni, int posicion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.dni = dni;
		this.posicion = posicion;
		setNumeroPersonas(getNumeroPersonas() + 1);
	}

	public Persona(String nombre, int edad, double peso, String dni, int posicion, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.dni = dni;
		this.posicion = posicion;
		this.direccion = direccion;
		setNumeroPersonas(getNumeroPersonas() + 1);
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}	

	public int getPosicion(){

		return posicion;
	}
	
	public void correr(int metros){
		System.out.println("Soy la persona " + nombre + " y voy a correr "
				+ metros + " metros");
		posicion += metros;
	}

	

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", dni=" + dni + ", posicion="
				+ posicion + ", direccion=" + direccion + "]";
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	//sobrescribimos mediante generate->override methods->elegimos 
	//equal
	
	@Override
	protected void finalize() throws Throwable {
		setNumeroPersonas(getNumeroPersonas() - 1);
	}

	public static int getNumeroPersonas() {
		return numeroPersonas;
	}

	public static void setNumeroPersonas(int numeroPersonas) {
		Persona.numeroPersonas = numeroPersonas;
	}
	
	
	public Persona esMayor(Persona persona){
		if(this.edad > persona.edad){
			return this;
		}else{
			return persona;
		}
	}
}
