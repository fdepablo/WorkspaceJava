import java.util.Scanner;

public class Partida {
	private Personaje p1;
	private Personaje p2;
	
	public Partida(Personaje p1, Personaje p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void empezar() {
		
		System.out.println("BIENVENIDOS A NUESTRO COMBATE!!!");
		System.out.println("LUCHADOR 1: " + p1);
		System.out.println("LUCHADOR 2: " + p2);
		
		boolean acabada = false;
		Personaje personajeGanador = null;
		int turno = 1;
		do {
			System.out.println("Pulse enter para continuar!");
			new Scanner(System.in).nextLine();
			System.out.println("**************************");
			System.out.println("******* TURNO " + turno++ + "*******");
			int danio = p1.atacar(p2);
			System.out.println("Daño hecho por " + p1.getNombre() 
			+ " ha sido " + danio);
			danio = p2.atacar(p1);
			System.out.println("Daño hecho por " + p2.getNombre() 
			+ " ha sido " + danio);
			
			System.out.println("Vida del p1 " + p1.getVida());
			System.out.println("Vida del p2 " + p2.getVida());
			
			if(p1.getVida() <= 0) {
				personajeGanador = p2;
				acabada = true;
			}else if(p2.getVida() <= 0) {
				personajeGanador = p1;
				acabada = true;
			}
		}while(!acabada);
		
		System.out.println("TENEMOS UN GANADOR!!!!");
		System.out.println(personajeGanador);
	}
}
