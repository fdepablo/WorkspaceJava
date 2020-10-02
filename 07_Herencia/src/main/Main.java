package main;

import java.util.ArrayList;

import entidades.*;

public class Main {
	public static void main(String[] args) {
		//Animal a = new Animal();
		Trucha trucha = new Trucha();
		trucha.setNombre("Tomasa");
		trucha.setPeso(7.0);
		
		Ballena ballena = new Ballena();
		ballena.setNombre("mobidic");
		ballena.setPeso(180000.125);
		
		Tiburon tiburon = new Tiburon();
		tiburon.setNombre("Robustiano");
		tiburon.setPeso(300.5);
		
		Oso oso = new Oso(TipoOso.PARDO);
		oso.setNombre("Yogui");
		oso.setPeso(400);
		oso.setTamanio(Tamanio.GRANDE);
		
		ArrayList<Animal> listaAnimales = new ArrayList<>();
		listaAnimales.add(trucha);
		listaAnimales.add(ballena);
		listaAnimales.add(tiburon);
		listaAnimales.add(oso);
		
		Object comida = new Placton();
		for(Animal animal : listaAnimales){
			animal.comer(comida);
		}
		
		Animal truchaComida = new Trucha();
		truchaComida.setNombre("Pepa");
		System.out.println("----------------------");
		for(Animal animal : listaAnimales){
			animal.comer(truchaComida);
		}
		
		Pez ballenaComida = new Ballena();
		ballenaComida.setNombre("Pinocho");
		
		System.out.println("----------------------");
		for(Animal animal : listaAnimales){
			animal.comer(ballenaComida);
		}
	}
}
