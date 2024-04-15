package _09_enumerados;

public class Direccion {
	private TipoVia tipoVia;
	private String nombreVia;
	
	public TipoVia getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(TipoVia tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + "]";
	}

	
	
}
