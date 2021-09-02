package entidad;

//Clase diseñada como JavaBean. Un JavaBean es una clase que tiene
//atribuitos privados y metodos accesores y modificadores de dichos
//atributos publicos (Getters y setters). Es un convenio de diseño de clases importantismo
public class Jugador extends Persona implements Movible{
	private String nombre;
	private double peso;

	//Esto seria unidireccinoal si pongo el atributo solo aqui, 
	//es decir, a partir de un jugador puedo sacar su direccion
	//Las asociciaciones implican bidireccionalidad
	private Direccion direccion;

	
	//Composicion es cuando el ciclo de vida del objeto compuesto depende
	//plenamente del objeto contenido
	//En java se implenta haciendo UNA unica refencia en la clase y tambien
	//haciendo NEW dentre de la clase
	//En este caso hacemos el NEW dentro del constructor
	private Historial historial;

	public Jugador() {
		historial = new Historial();
	}
	
	//metodo accesor, empieza obligatoriamente por get y luego
	//el atributo en camelcase
	public String getNombre() {
		return nombre;
	}

	//metodo modificador
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
		
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void chutar() {
		System.out.println("Soy el jugador " + nombre + " y chuto a puerta");
	}

	@Override
	public void moverseLento() {
		System.out.println("Soy el jugador " + nombre + " y me muevo 5 metros");		
	}

	@Override
	public void moverseRapido() {
		System.out.println("Soy el jugador " + nombre + " y me muevo 20 metros");		
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
}
