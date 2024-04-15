package _07_relaciones;

import java.util.Arrays;

//Joder que muñonada he metido antes :) :P
public class Persona {
	String nombre;
	Direccion direccion;//1-1 en BBDD
	CuentaBancaria[] cuentasBancarias;//1-N
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", cuentasBancarias="
				+ Arrays.toString(cuentasBancarias) + "]";
	}
	
	
}
