package juego.entidades;


public class Partida{
	private int velocidad;
	private int puntuacion;
	private String nombreJugador;
	
	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public Partida() {
				
	}
	
	@Override
	public String toString() {
		return "Partida [velocidad=" + velocidad + ", puntuacion=" + puntuacion + ", jugador=" + nombreJugador + "]";
	}

}
