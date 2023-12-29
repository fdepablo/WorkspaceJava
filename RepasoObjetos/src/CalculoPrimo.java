
public class CalculoPrimo extends Thread {

	private long numero;

	public CalculoPrimo(long numero) {
		this.numero = numero;
	}

	public void run() {

		long aux = System.currentTimeMillis();

		boolean esPrimo = true;

		for (int x = 2; x <= numero / 2; x++) {
			if (numero % x == 0) {
				esPrimo = false;
			}
		}		
		
		long aux2 = System.currentTimeMillis();
		long tiempoFinal = aux2 - aux;
		
		if (esPrimo == true) {
			System.out.println("El número: " + this.numero + " SI es primo");
		}
		if (esPrimo == false) {
			System.out.println("El número: " + this.numero + " NO es primo");
		}

		System.out.println("Tiempo final ha sido:" + tiempoFinal + " milisegundos");
	}
}
