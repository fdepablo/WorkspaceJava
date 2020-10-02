package _02_personalizadas;

public class CuentaBancaria {
	private double saldo;

	public CuentaBancaria(double sld) {
		saldo = sld;
	}

	// Método que lanza nuestra excepción personalizada
	public void sacarDinero(double cantidad) throws SaldoNegativoException {
		if (cantidad > saldo) {
			// Lanzamiento de la excepción
			throw new SaldoNegativoException("Fondos insuficientes");
		}
		saldo -= cantidad;
	}
}
