package _01_basico;

//Una manera de crear hilos en java, es extendiendo de
//la clase Thread que ya esta implementada en la JDK
public class _01_HiloThread extends Thread {

	private String saludoDesdeHilo;

	// String name
	public _01_HiloThread(String saludoDesdeHilo) {
		this.saludoDesdeHilo = saludoDesdeHilo;
	}

	// Una vez que arranquemos el hilo, inmediantamente despues ejecutar� el 
	// metodo "run". Un hilo siempre se debe arrancar con el metodo "start"
	// que esta implementado en la clase Thread, y sera este el que llame a su
	// vez al metodo "run"
	// Este metodo lo podemos entender como un "main"
	// La ciclo de vida de este hilo ser�a desde el inicio del metodo hasta el 
	// final del mismo
	@Override
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep(500);//simulacion de tarea que tarda 500 milisegungdos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 0.5 segundos

			System.out
					.println("Hilo: " + Thread.currentThread().getName() 
							+ " , dice: " + saludoDesdeHilo + " ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
	}// El hilo muere en esta linea
}
