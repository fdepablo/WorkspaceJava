package _03_sincronizado_01;

public class HiloSincronizado implements Runnable {
	private String palabra1,palabra2;
	private DosPalabras dosPalabras;
	
	public HiloSincronizado(String palabra1,String palabra2, DosPalabras dosPalabras) {
		this.palabra1 = palabra1;
		this.palabra2 = palabra2;
		this.dosPalabras = dosPalabras;
	}
	
	@Override
	public void run() {
		dosPalabras.escribir(palabra1, palabra2);
	}

}
