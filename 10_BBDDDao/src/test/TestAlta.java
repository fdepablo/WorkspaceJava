package test;

import modelo.entidad.Persona;
import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestAlta {
	public static void main(String[] args) {
		Persona persona = new Persona();
		persona.setNombre("Filemon");
		persona.setEdad(45);
		persona.setPeso(66.5);
		
		DaoPersona dp = new DaoPersonaMySql();
		boolean alta = dp.alta(persona);
		if(alta){
			System.out.println("La persona se ha dado de alta");
		}else{
			System.out.println("La persona NO se ha dado de alta");
		}
	}
}
