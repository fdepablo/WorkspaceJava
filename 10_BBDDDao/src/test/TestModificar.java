package test;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersonas;

public class TestModificar {
	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("Maria");
		persona.setEdad(30);
		persona.setPeso(70);
		
		GestorPersonas gp = new GestorPersonas();
		
		boolean modificar = gp.modificar(persona);
		if(modificar){
			System.out.println("La persona se ha modificado");
		}else{
			System.out.println("La persona NO se ha modificado");
		}
	}
}
