package expcepciones_personalizadas;

public class CuentaBancaria {
	private double saldo;

	public CuentaBancaria(double sld) {
		saldo = sld;
	}

	// M�todo que lanza nuestra excepci�n personalizada
	public void sacarDinero(double cantidad) throws SaldoNegativoException {
		if (cantidad > saldo) {
			// Lanzamiento de la excepci�n
			throw new SaldoNegativoException("Fondos insuficientes");
		}
		saldo -= cantidad;
	}
}
