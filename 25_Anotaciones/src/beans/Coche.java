package beans;

import anotaciones.Autor;

@Autor
public class Coche {
	private String marca;
	private String modelo;
	private int velocidad;
	
	public Coche(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = 0;
	}

	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getVelocidad() {
		return velocidad;
	}

	@Autor(nombre="Perico de los palotes", direccion="C/ Palotes, 54") 
	public void acelerar() {
		this.velocidad = this.velocidad + 10;
	}

	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", modelo=" + modelo + ", velocidad=" + velocidad + "]";
	}
}
