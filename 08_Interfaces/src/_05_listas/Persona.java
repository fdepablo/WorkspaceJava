package _05_listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import _04_basico.vehiculos.Coche;

public class Persona {
	private String nombre;
	//Si ponemos el tipo de atributo como la interfaz, dejamos
	//abierto a que los programadores puedan poner el tipo
	//de lista que quieran (ArrayList y LinkedList) y NO
	//permitimo solo un tipo
	//Es MUY buena práctica de programación usar interfaces
	//en lugar de implemtaciones concretas
	private List<Coche> listaCoches;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	
	
}
