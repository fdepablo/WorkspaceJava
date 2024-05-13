package _04_basico.animales;

public class Cangrejo extends Pez{

	@Override
	public void moverseLento() {
		double movimiento = 10 - (getPeso() * 0.10);
		System.out.println("Soy un Cangrego y me muevo " + movimiento);
	}

	@Override
	public void moverseRapido() {
		double movimiento = 20 - (getPeso() * 0.10);
		System.out.println("Soy un Cangrego y me muevo " + movimiento);
	}

}
