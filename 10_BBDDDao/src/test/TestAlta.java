package test;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersonas;

public class TestAlta {
	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.setNombre("Ramon");
		persona.setEdad(45);
		persona.setPeso(76.5);
		
		GestorPersonas gestorPersonas = new GestorPersonas();
		boolean alta = gestorPersonas.alta(persona);
		if(alta){
			System.out.println("La persona se ha dado de alta");
		}else{
			System.out.println("La persona NO se ha dado de alta");
		}
	}
}
