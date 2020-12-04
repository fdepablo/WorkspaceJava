package _05_firmadigital;

import java.io.Serializable;
import java.security.PublicKey;

public class MensajeFirmado implements Serializable {
	private static final long serialVersionUID = 8700992515811830138L;
	
	private PublicKey clavePublica;
	private byte[] firmaDigital;
	
	public MensajeFirmado(PublicKey clavePublica, byte[] firmaDigital) {
		this.clavePublica = clavePublica;
		this.firmaDigital = firmaDigital;
	}

	public PublicKey getClavePublica() {
		return clavePublica;
	}
	public byte[] getFirmaDigital() {
		return firmaDigital;
	}
}
