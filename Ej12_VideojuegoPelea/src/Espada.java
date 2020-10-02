import java.util.Random;

public class Espada extends Arma{

	
	public int usar() {
		System.out.println("Swaaaaanggg");
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMinimo()) + 1) + getDanioMinimo();
	
	}

	
}
