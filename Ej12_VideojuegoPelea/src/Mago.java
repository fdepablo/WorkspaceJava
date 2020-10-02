import java.util.Random;

public class Mago extends Personaje {

	public int atacar(Personaje p) {
		//this hace referencia al propio objeto
		System.out.println("soy el personaje " + getNombre() + 
				" y voy a atacar a " + p.getNombre());
		//los magos pueden hacer un ataque critico que hace
		//el doble de daño, hay un 30% de posibilidades de hacerlo
		Random r = new Random();
		int aleatorio = r.nextInt((100 - 1) + 1) + 1;
		int danioArma = getArma().usar();
		if(aleatorio <= 30) {//critico
			System.out.println("CRITICO!! TOMA GEROMA!!");
			danioArma *= 2;
		}
		
		int vidaActual = p.getVida() - danioArma;
		p.setVida(vidaActual);
		return danioArma;
	}
}
