package _07_relaciones;

import java.util.Arrays;

public class Persona {
	String nombre;
	//La dirección al ser compuesta mejor crear una clase
	//porque si fuera un String quedaría algo así "Calle Gran Via 34, 28345..."
	Direccion direccion;//1-1 en BBDD
	//Direccion direccionDeVacaciones;//Si tuvieramos otra, podríamos declararla
	CuentaBancaria[] cuentasBancarias;//1-N
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", cuentasBancarias="
				+ Arrays.toString(cuentasBancarias) + "]";
	}
	
	
}
