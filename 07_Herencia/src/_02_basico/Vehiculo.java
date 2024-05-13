package _02_basico;

public class Vehiculo {
	private String marca;
	private double peso;
	private double velocidad;
	/**
	 * Formato dd/mm/YYYY
	 */
	private String fechaFabricacion;
	
	/**
	 * Método que devuelve si el vehiculo es antiguo o no. 
	 * Un vehiculo es antiguo cuando su año de fabricación
	 * sea menor que 2000
	 * @return true si es antiguo, false en caso contrario
	 */
	public boolean esAntiguo() {
		String sAnio = fechaFabricacion.split("/")[2];
		int iAnio = Integer.parseInt(sAnio);
		if(iAnio <  2000) {
			return true;
		}else {
			return false;
		}
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(String fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", peso=" + peso + ", velocidad=" + velocidad + ", fechaFabricacion="
				+ fechaFabricacion + "]";
	}
	
	
	
	
}
