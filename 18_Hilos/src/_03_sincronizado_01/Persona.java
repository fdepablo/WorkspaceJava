package _03_sincronizado_01;

public class Persona implements Runnable {
	private String nombre;
	private String frase1,frase2;
	private Fiesta fiesta;
	
	public Persona(String nombre,String frase1,String frase2, Fiesta fiesta) {
		this.nombre = nombre;
		this.frase1 = frase1;
		this.frase2 = frase2;
		this.fiesta = fiesta;
	}
	
	@Override
	public void run() {
		fiesta.entrar(nombre,frase1, frase2);
	}

}
