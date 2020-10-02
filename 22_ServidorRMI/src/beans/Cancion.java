package beans;

import java.io.Serializable;

//Seriazable permite pasar un objeto a un flujo de bytes para que pueda ser
//sacado de la jvm a otro entorno (por ejemplo, otra jmv, un fichero, etc)
public class Cancion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7704932698362948241L;
	
	private int id;
	private String titulo;
	private String banda;
	private String album;
	private int producido;
		
	public Cancion(int id,String titulo, String banda, String album, int producido) {
		this.titulo = titulo;
		this.banda = banda;
		this.album = album;
		this.producido = producido;
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getBanda() {
		return banda;
	}
	public String getAlbum() {
		return album;
	}
	public int getProducido() {
		return producido;
	}

	@Override
	public String toString() {
		return titulo + " (" + banda + ") Álbum=" + album + " - " + producido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
