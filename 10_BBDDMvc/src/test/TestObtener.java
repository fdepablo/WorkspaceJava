package test;

import java.util.List;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersona;

public class TestObtener {
	public static void main(String[] args) {
		GestorPersona gp = new GestorPersona();
		Persona persona = gp.obtener(1);
		System.out.println(persona);
		
		System.out.println("*******************");
		
		List<Persona> listaPersonas = gp.listar();
		for(Persona p : listaPersonas){
			System.out.println(p);
		}
	}
}
