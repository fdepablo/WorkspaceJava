package entidad;

/**
 * Una direccion encapsula un tipo de via y un nombre de via
 * 
 * @author Tony Stark
 * @version 1.5
 *
 */
public class Direccion {
	private String tipoVia;
	private String nombreVia;
	
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
}
