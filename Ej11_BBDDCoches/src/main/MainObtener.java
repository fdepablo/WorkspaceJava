package main;

import java.util.List;

import entidades.Coche;
import negocio.GestorCoches;

public class MainObtener {
	public static void main(String[] args) {
		GestorCoches gc = new GestorCoches();
		Coche coche = gc.obtener(1);
		System.out.println(coche);
		
		System.out.println("*******************");
		
		List<Coche> listaCoches = gc.listar();
		for(Coche p : listaCoches){
			System.out.println(p);
		}
	}
}
