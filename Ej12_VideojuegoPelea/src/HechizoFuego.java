import java.util.Random;

public class HechizoFuego extends Arma {

	@Override
	public int usar() {
		System.out.println("Fireball!!!!");
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMinimo()) + 1) + getDanioMinimo();
	
	}

}
