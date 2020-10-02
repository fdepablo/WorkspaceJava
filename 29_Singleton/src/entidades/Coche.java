package entidades;

import java.io.Serializable;

public class Coche implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -143642099989707561L;
	
	private String Matricula;
	private  String modelo;
	
	
	
	public Coche(String matricula, String modelo) {
		super();
		Matricula = matricula;
		this.modelo = modelo;
	}
	public String getMatricula() {
		return Matricula;
	}
	public void setMatricula(String matricula) {
		Matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	@Override
	public String toString() {
		return "Coche [Matricula=" + Matricula + ", modelo=" + modelo + "]";
	}
	
	
}
