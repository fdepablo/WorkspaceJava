package _03_ficheros_binarios;

public class Producto {
	private String nombre;
	private float precio;	
	private int unidadesEnExistencia;
	
	public Producto(String nombre, float precio, int unidadesEnExistencia) {
		this.nombre = nombre;
		this.precio = precio;
		this.unidadesEnExistencia = unidadesEnExistencia;
	}

	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public int getUnidadesEnExistencia() {
		return unidadesEnExistencia;
	}

	@Override
	public String toString() {
		return nombre + " Stock: " + this.unidadesEnExistencia + " Precio: " + this.precio;
	}
}