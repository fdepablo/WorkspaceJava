
public abstract class Personaje {
	private Arma arma;
	private String nombre;
	private int vida;
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	public int atacar(Personaje p) {
		//this hace referencia al propio objeto
		System.out.println("soy el personaje " + this.nombre + 
				" y voy a atacar a " + p.nombre);
		int danio = arma.usar();
		int vidaActual = p.getVida() - danio;
		p.setVida(vidaActual);
		return danio;
	}
	
	@Override
	public String toString() {
		return "Personaje [arma=" + arma + ", nombre=" + nombre + ", vida=" + vida + "]";
	}
	
	
}
