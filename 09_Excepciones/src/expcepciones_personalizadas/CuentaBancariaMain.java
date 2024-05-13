
package expcepciones_personalizadas;

public class CuentaBancariaMain {
	public static void main(String[] args) {
		CuentaBancaria cb = new CuentaBancaria(1000.0);
		try {
			// Instrucci�n que no genera error
			cb.sacarDinero(500.0);
			// Instrucci�n que genera una excepci�n
			cb.sacarDinero(1200.0);
		} catch (SaldoNegativoException sne) {
			// Mostramos el mensaje definido en
			// el constructor de la excepci�n
			System.out.println(sne.getMessage());
			//mostramos el mensaje sobreescrito
			System.out.println(sne.getLocalizedMessage());
			// Imprimimos la traza por pantalla
			sne.printStackTrace();
		}
	}
}
