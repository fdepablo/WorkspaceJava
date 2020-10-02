package modelo.entidades;

public class Habitacion {
	private double metros;
	private TipoHabitacion tipoHabitacion;
	public double getMetros() {
		return metros;
	}
	public void setMetros(double metros) {
		this.metros = metros;
	}
	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	@Override
	public String toString() {
		return "Habitacion [metros=" + metros + ", tipoHabitacion=" + tipoHabitacion + "]";
	}
	
	
}
