
package _01_basico;

public class _01_MainHiloThread {

	public static void main(String[] args) {
		
		//Este objeto sera capaz de arrancar un hilo
		_01_HiloThread hilo1 = new _01_HiloThread("Valor 1");
		hilo1.setName("Hilo1");//establecemos el nombre del hilo
		
		_01_HiloThread hilo2 = new _01_HiloThread("Valor 2");
		hilo2.setName("Hilo2");
		
		try {
			//Duerme el hilo que passe por aqui durante un tiempo
			//En este caso, siempre sera el main
			System.out.println("Esperando 5 segundos a arrancar los hilos... :), que nervios...");
			Thread.sleep(5000);//5 seg
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//arrancamos los dos hilos
		//ojo no se ejecuta run()
		//con start invocamos implicitamente el metodo run() pero arrancando un hilo nuevo en nuestra JVM
		hilo1.start();		
		hilo2.start();
		
		System.out.println("Programa principal parando");
		//El hilo principal acaba aqui, pero mientras haya un hilo en ejecución,
		//el programa serguiera existiendo
	}

}
