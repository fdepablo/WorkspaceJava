package entidades;

import java.io.Serializable;

import interfaces.Movible;

public abstract class Animal implements Movible, Serializable{

	private static final long serialVersionUID = -6034443877129271187L;
	
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

	@Override
	public void moverseLento() {
		System.out.println("Soy un animal y me muevo 5 metros");
		
	}

	@Override
	public void moverseRapido() {
		System.out.println("Soy un animal y me muevo 15 metros");
		
	}
	
	
}
