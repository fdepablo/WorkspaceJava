package _03_sincronizado_01;

public class Persona implements Runnable {
	private String palabra1,palabra2;
	private Fiesta fiesta;
	
	public Persona(String palabra1,String palabra2, Fiesta fiesta) {
		this.palabra1 = palabra1;
		this.palabra2 = palabra2;
		this.fiesta = fiesta;
	}
	
	@Override
	public void run() {
		fiesta.entrar(palabra1, palabra2);
	}

}
