package _08_visibilidades.relaciones;

public class CuentaBancaria {
	private String iban;
	private double saldo;
	
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "CuentaBancaria [iban=" + iban + ", saldo=" + saldo + "]";
	}
}
