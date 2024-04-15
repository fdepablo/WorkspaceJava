package _08_visibilidades;

//Normalmente las clases que representan entidades en java
//siguen la convención JavaBean, ya que muchas aplicaciones
//la exijen para que funcionen.

//Esta convención dice:
//1. atributos privados
//2. métodos accesores y modificadores (setter y getters)
//3. constructor por defecto
public class Pokemon {
	private int vida;
	private String nombre;
	private int experiencia;
	
	public Pokemon(int vida, String nombre, int experiencia) {
		super();
		this.vida = vida;
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public Pokemon() {
		super();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		if(vida < 0) {
			this.vida = 0;
		}else {
			this.vida = vida;		
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	
}
