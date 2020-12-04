package entidad;

public class MensajeHTML {
	private String texto;
	private static long peticiones;
	
	public MensajeHTML(String texto) {
		this.texto = texto;
		peticiones ++;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPeticiones() {
		return "Accesos desde el inicio del servidor: " + peticiones;
	}
}
