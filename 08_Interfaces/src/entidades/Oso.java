package entidades;

public class Oso extends Animal{

	private static final long serialVersionUID = 1L;
	private TipoOso tipoOso;
	
	public Oso(TipoOso tipoOso){
		this.tipoOso = tipoOso;
	}
	
	@Override
	public void comer(Object comida) {
		if(comida instanceof Trucha){
			//Trucha trucha = (Trucha)comida;
			System.out.println("UMMMMMMM que buena una trucha!!! me la"
					+ " voy a zampar como me llamo " + this.nombre);
		}else{
			System.out.println("No me gusta eso que me has dado");
		}
		
	}

	public TipoOso getTipoOso() {
		return tipoOso;
	}

	public void setTipoOso(TipoOso tipoOso) {
		this.tipoOso = tipoOso;
	}

	@Override
	public String toString() {
		return "Oso [tipoOso=" + tipoOso + ", peso=" + peso + ", tamanio=" + tamanio + ", nombre=" + nombre + "]";
	}

	@Override
	public void moverseLento() {
		System.out.println("Hola soy un oso y me muevo 7,5 metros");
	}

	@Override
	public void moverseRapido() {
		System.out.println("Hola soy un oso y me muevo 20 metros");
	}
	
	
	
	
}
