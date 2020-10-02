package modelo.entidades;

import java.util.ArrayList;

public class Casa {
	private double precio;
	private Direccion direccion;
	private ArrayList<Habitacion> listaHabitaciones;
	private ArrayList<Persona> listaInquilinos;
	private Persona propietario;
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Habitacion> getListaHabitaciones() {
		return listaHabitaciones;
	}
	public void setListaHabitaciones(ArrayList<Habitacion> listaHabitaciones) {
		this.listaHabitaciones = listaHabitaciones;
	}
	public ArrayList<Persona> getListaInquilinos() {
		return listaInquilinos;
	}
	public void setListaInquilinos(ArrayList<Persona> listaInquilinos) {
		this.listaInquilinos = listaInquilinos;
	}
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	
	@Override
	public String toString() {
		return "Casa [precio=" + precio + ", direccion=" + direccion + ", listaHabitaciones=" + listaHabitaciones
				+ ", listaInquilinos=" + listaInquilinos + ", propietario=" + propietario + "]";
	}
	
	public double getM2() {
		double m2totales = 0;
		
		for(Habitacion h : listaHabitaciones) {
			m2totales += h.getMetros();
		}
		
		return m2totales;
	}
	
}
