package _01_basico;

// La otra manera de crear hilos en java es implementando la
//interfaz Runnable. Este ejemplo es funcionalmente igual
//al de HiloThread
// Usaremos Runnable cuando la clase que queramos convertir
//en un hilo ya extienda de otra, recordemos que java no
//permite la herencia multiple
public class _02_HiloRunnable implements Runnable{
	
	private String valorImprimir;

	// String name
	public _02_HiloRunnable(String valorImprimir) {
		this.valorImprimir = valorImprimir;
	}

	// Una vez que arranquemos el hilo, inmediantamente despues de ejecutar el 
	// metodo "run". Un hilo siempre se debe arrancar con el metodo "start",
	// que esta implementado en la clase Thread; sera este el que llame a su
	// vez al metodo "run"
	// Este metodo lo podemos entender como un "main"
	// El ciclo de vida de este hilo ser�a desde el inicio del metodo hasta el 
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
