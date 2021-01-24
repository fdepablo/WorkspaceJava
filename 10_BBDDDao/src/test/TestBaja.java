package test;

import modelo.persistencia.DaoPersonaMySql;
import modelo.persistencia.interfaces.DaoPersona;

public class TestBaja {
	public static void main(String[] args) {
		DaoPersona dp = new DaoPersonaMySql();
		
		boolean baja = dp.baja(11);
		if(baja){
			System.out.println("La persona se ha dado de baja");
		}else{
			System.out.println("La persona NO se ha dado de baja");
		}
	}
}
