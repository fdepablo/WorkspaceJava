package entidades;

public abstract class Animal {
	//Tenemos visibilidad en
	//La propia clase
	//Las clases que extiendan de ella
	//las clases dentro del propio paquete
	//(entidades)
	protected double peso;
	protected Tamanio tamanio;
	protected String nombre;
	
	public abstract void comer(Object comida);

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Tamanio getTamanio() {
		return tamanio;
	}

	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
