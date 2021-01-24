package test;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestModificar {
	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.setId(10);
		persona.setNombre("Mortadelo");
		persona.setEdad(40);
		persona.setPeso(73.5);
		
		DaoPersona dp = new DaoPersonaMySql();
		
		boolean modificar = dp.modificar(persona);
		if(modificar){
			System.out.println("La persona se ha modificado");
		}else{
			System.out.println("La persona NO se ha modificado");
		}
	}
}
