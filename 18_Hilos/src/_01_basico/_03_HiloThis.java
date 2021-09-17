package _01_basico;

//Este ejemplo sirve en caso de que queramos arrancar el hilo cuando
//creamos un objeto de este tipo, es decir, sin que en el hilo main
//tengamos que invocar el metodo start()

//Este ejemplo tiene el mismo comportamiento que los otros ejemplos de hilos
public class _03_HiloThis implements Runnable{
	private String valorImprimir;

	// String name
	public _03_HiloThis(String valorImprimir, String nombreHilo) {
		this.valorImprimir = valorImprimir;
		Thread t1 = new Thread(this,nombreHilo);
		t1.start();
	}

	@Override 
	public void run() {
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());
		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out
					.println("Hilo: " + Thread.currentThread().getName() 
							+ " , dice: " + valorImprimir + "ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
	}
}
