package entidad;

import javax.xml.bind.annotation.XmlRootElement;

// La manera más sencilla de trabajar con una clase es usando únicamente
//la anotación "@XMLRootElement". 
// En este caso pondría como nodo padre "dirección" y como 
//nodos elementos hijos "tipoVia", "nombreVia" y "cp".
//Ejemplo de XML serializado:
/*
 * <direccion>
 *  <cp>VALOR</cp>
 *  <nombreVia>VALOR</nombreVia>
 * 	<tipoVia>VALOR</tipoVia> *  
 * </dirección>
 * 
 */

//Nótese que solo está la anotación "@XmlRootElement"
@XmlRootElement
public class Direccion {
	private String tipoVia;
	private String nombreVia;
	private String cp;
	
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", cp=" + cp + "]";
	}
	
	
}
