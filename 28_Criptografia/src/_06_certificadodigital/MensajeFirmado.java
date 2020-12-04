package _06_certificadodigital;

import java.io.Serializable;
import java.security.PublicKey;

public class MensajeFirmado implements Serializable {
	private static final long serialVersionUID = 8700992515811830138L;
	
	private PublicKey clavePublica;
	private byte[] firma;
	
	public MensajeFirmado(PublicKey clavePublica, byte[] firma) {
		this.clavePublica = clavePublica;
		this.firma = firma;
	}

	public PublicKey getClavePublica() {
		return clavePublica;
	}
	public byte[] getFirma() {
		return firma;
	}
}
