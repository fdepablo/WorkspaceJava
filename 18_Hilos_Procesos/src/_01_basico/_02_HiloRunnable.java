package _01_basico;

// La otra manera de crear hilos en java es implementando la
//interfaz runnable. Este ejemplo es un funcionalmente igual
//al HiloThread
// Usaremos esta manera cuando la clase que queramos convertirla
//en un hilo ya extienda de otra, ya que recordemos que java no
//permiete la herencia multiple
public class _02_HiloRunnable implements Runnable{
	
	private String valorImprimir;

	// String name
	public _02_HiloRunnable(String valorImprimir) {
		this.valorImprimir = valorImprimir;
	}

	// Una vez que arranquemos el hilo, inmediantamente despues ejecutará el 
	// metodo "run". Un hilo siempre se debe arrancar con el metodo "start"
	// que esta implementado en la clase Tread, y sera este el que llame a su
	// vez al metodo "run"
	// Este metodo lo podemos entender como un "main"
	// La ciclo de vida de este hilo sería desde el inicio del metodo hasta el 
	// final del mismo
	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(500);//simulacion de tarea que tarda 500 milisegungdos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 0.5 segundos

			System.out
					.println("Hilo: " + Thread.currentThread().getName() 
							+ " , dice: " + valorImprimir + " ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		for(int i = 0; i<= 9;i++) {
			
		}		
	}
}
