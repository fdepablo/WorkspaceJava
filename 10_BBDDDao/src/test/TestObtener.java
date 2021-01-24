package test;

import java.util.List;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestObtener {
	public static void main(String[] args) {
		DaoPersona dp = new DaoPersonaMySql();
		Persona persona = dp.obtener(10);
		System.out.println(persona);
		
		System.out.println("********* LISTANDO TODAS LAS PERSONAS **********");
		
		List<Persona> listaPersonas = dp.listar();
		for(Persona p : listaPersonas){
			System.out.println(p);
		}
	}
}
