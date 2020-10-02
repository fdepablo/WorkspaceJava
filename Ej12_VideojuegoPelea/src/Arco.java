import java.util.Random;

public class Arco extends Arma{
	
	public int usar() {
		System.out.println("Siiiiiiuuuuuuu!");
		//from mykong
		Random r = new Random();
		return r.nextInt((getDanioMax() - getDanioMinimo()) + 1) + getDanioMinimo();
	}
}
