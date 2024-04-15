package _05_arrays;

import java.util.Arrays;

public class Restaurante {
	int id;//0
	String nombre;//null
	double[] puntuaciones;//null
	
	public Restaurante() {
		super();
	}
	
	public Restaurante(int id, String nombre, double[] puntuaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntuaciones = puntuaciones;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", puntuaciones=" + Arrays.toString(puntuaciones) + "]";
	}
	
	
}
