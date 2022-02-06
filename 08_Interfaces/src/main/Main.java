

package main;

import java.util.ArrayList;

import entidades.*;
import interfaces.Movible;

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
		
		System.out.println("********** Carrera ************");
		Persona carl = new Persona();
		carl.setNombre("carl");
		carl.setCapacidadMovimiento(15);
		
		//Clases anonimas
		Movible coche = new Movible() {			
			@Override
			public void moverseRapido() {
				System.out.println("Soy un coche y me muevo a 40");
			}
			
			@Override
			public void moverseLento() {
				System.out.println("Soy un coche y me muevo a 20");
				
			}
		};
		
		ArrayList<Movible> listaParticipantes = new ArrayList<>();
		listaParticipantes.add(carl);
		listaParticipantes.add(ballena);
		listaParticipantes.add(oso);
		listaParticipantes.add(tiburon);
		listaParticipantes.add(coche);
		
		Movible movible2 = ballena;
		Ballena ballena2 = (Ballena)movible2;
		//String s = new String();
		//listaParticipantes.add(s);
		for(Movible movible : listaParticipantes){
			movible.moverseRapido();
		}
	}
}
