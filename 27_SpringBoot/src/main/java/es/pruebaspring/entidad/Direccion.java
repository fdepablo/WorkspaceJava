package es.pruebaspring.entidad;

import org.springframework.stereotype.Component;

@Component
public class Direccion {
	private String nombreVia;
	private int cp;
	
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", cp=" + cp + "]";
	}
	
}
