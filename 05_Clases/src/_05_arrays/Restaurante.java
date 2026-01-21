package _05_arrays;

import java.util.Arrays;

public class Restaurante {
	int id;// Por defecto 0
	String nombre;//Por defecto null
	double[] puntuaciones;//Por defecto null
	
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
	
	public double calcularMedia() {
		double suma = 0;
		for(double puntuacion : puntuaciones) {
			suma += puntuacion;
		}
		double media = suma / puntuaciones.length;
		return media;
	}
	
	
}
