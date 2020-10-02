package entidad;

public class Direccion {
	private String tipoVia;
	private String nombreVia;
	
	//si quiero tener bidireccionallidad, debo tener aqui tambien
	//un atributo de tipo Jugador
	private Jugador jugador;
	
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
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	
}
