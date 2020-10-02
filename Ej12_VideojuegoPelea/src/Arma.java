
public abstract class Arma {
	private String tipo;
	private int danioMax;
	private int danioMinimo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public int getDanioMax() {
		return danioMax;
	}

	public void setDanioMax(int danioMax) {
		this.danioMax = danioMax;
	}

	public int getDanioMinimo() {
		return danioMinimo;
	}

	public void setDanioMinimo(int danioMinimo) {
		this.danioMinimo = danioMinimo;
	}

	public abstract int usar();

	@Override
	public String toString() {
		return "Arma [tipo=" + tipo + ", danioMax=" + danioMax + ", danioMinimo=" + danioMinimo + "]";
	}
	
	
}
