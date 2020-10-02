package modelo.entidades;

public class Direccion {
	private TipoVia tipoVia;
	private String nombreVia;
	private String CP;
	private int numero;
	
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
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", CP=" + CP + ", numero=" + numero + "]";
	}
	
	
}
