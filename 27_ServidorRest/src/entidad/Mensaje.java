package entidad;

public class Mensaje {
	private String texto;
	private static long peticiones;
	
	public Mensaje(String texto) {
		this.texto = texto;
		peticiones ++;
	}

	public String getTexto() {
		return texto + "\n" + "Acceso numero: " + peticiones;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static long getPeticiones() {
		return peticiones;
	}
}
