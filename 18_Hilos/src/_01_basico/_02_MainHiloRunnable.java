package _01_basico;

public class _02_MainHiloRunnable {
	public static void main(String[] args) {
		//Creamos un objeto que implemente Runnable
		_02_HiloRunnable hilo1 = new _02_HiloRunnable("Valor 1");
		//Creamos un objeto de tipo Thread (que es realmente el objeto que 
		//es capaz de crear hilos) y le pasamos un objeto de tipo Runnable
		Thread t1 = new Thread(hilo1);
		
		//ahora trabajos con el objeto de tipo Thread de igual manera que en el ejemplo
		//de HiloThread
		t1.setName("Hilo1");//establecemos el nombre del hilo
		
		
		_02_HiloRunnable hilo2 = new _02_HiloRunnable("Valor 2");
		//En vez de establecer el nombre por setter, lo podemos
		//establecer por constructor
		Thread t2 = new Thread(hilo2,"Hilo2");
				
		try {
			Thread.sleep(5000);//5 seg
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//arrancamos los dos hilos
		//ojo no se ejecuta run()
		t1.start();		
		t2.start();
		
		System.out.println("Hilo principal parando");
	}
}
