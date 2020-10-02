package _01_genericos;

//Si pusieramos
//T extends Perro
//obligariamos a que T sea de la clase Perro o que extienda de Perro
public class Almacen<T> {
	private T valorAlmacenado;

	public T getValorAlmacenado() {
		return valorAlmacenado;
	}

	public void setValorAlmacenado(T valorAlmacenado) {
		this.valorAlmacenado = valorAlmacenado;
	}

	
	
}
