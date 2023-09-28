package _03_sincronizado_01;

public class Avenger implements Runnable {
	private String nombre;
	private String saludo,frase;
	private Fiesta fiesta;
	
	public Avenger(String nombre,String saludo,String frase, Fiesta fiesta) {
		this.nombre = nombre;
		this.saludo = saludo;
		this.frase = frase;
		this.fiesta = fiesta;
	}
	
	//Cuando invocamos el método start(), se arranca el hilo y se ejecuta
	//el método run()
	@Override
	public void run() {
		fiesta.entrar(nombre,saludo,frase);
	}

}
