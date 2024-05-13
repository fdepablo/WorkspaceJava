package _05_listas;

//Esto se llama Generics en Java
public class Almacen<X> {
	private X dato;

	public X getDato() {
		return dato;
	}

	public void setDato(X dato) {
		this.dato = dato;
		
	}
}
