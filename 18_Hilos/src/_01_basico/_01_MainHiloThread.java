
package _01_basico;

public class _01_MainHiloThread {

	public static void main(String[] args) {
		
		//Este objeto sera capaz de arrancar un hilo
		_01_HiloThread hilo1 = new _01_HiloThread("El programa sigue en ejecucion, soy el hilo 1");
		hilo1.setName("Hilo1");//establecemos el nombre del hilo con el metodo setName de la clase Thread
		
		_01_HiloThread hilo2 = new _01_HiloThread("El programa sigue en ejecucion, soy el hilo 2");
		hilo2.setName("Hilo2");
		
		try {
			//Duerme el hilo que pase por aqui durante un tiempo
			//En este caso, siempre sera el main
			System.out.println("Esperando 5 segundos a arrancar los hilos... :), que nervios...");
			Thread.sleep(5000);//5 seg
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//arrancamos los dos hilos
		//ojo no se ejecuta run()
		hilo1.start();		
		hilo2.start();
		
		System.out.println("Hilo principal parando");
		//El hilo principal acaba aqui, pero mientras haya un hilo en ejecuci�n,
		//el programa seguira con vida. Cuando mueran todos los hilos que ha
		//arrancado un programa, sera entonces cuando el programa finalice
	}

}
