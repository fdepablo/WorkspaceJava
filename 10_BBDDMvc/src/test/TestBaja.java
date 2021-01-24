package test;

import modelo.negocio.GestorPersona;

public class TestBaja {
	public static void main(String[] args) {
		GestorPersona gp = new GestorPersona();
		
		boolean baja = gp.baja(1);
		if(baja){
			System.out.println("La persona se ha dado de baja");
		}else{
			System.out.println("La persona NO se ha dado de baja");
		}
	}
}
