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
		Thread t1 = new Thread(this,nombreHilo);//esto tambien vale
		//t1.setName(nombreHilo);//esto vale
		t1.start();
	}

	// Seria como un "main"
	// que para sobreescribir un metodo tiene que tener la misma firma
	// 1- El numero de parametros de entrada
	// 2- El tipo de parametros de entrada
	// 3- El nombre del metodo
	@Override //este metodo nos asegura que en tiempo de compilacion estamos sobreescribiendolo
	public void run() {
		//aqui nacera el hilo
		System.out.println("Arrancando hilo: " + Thread.currentThread().getName());//obtenemos el nombre del hilo
		for (int i = 0; i < 20; i++) {

			try {
				Thread.sleep(500);//simulacon de tarea que tarda 500 milisegungdos
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 0.5 segundos

			System.out
					.println("Hilo: " + Thread.currentThread().getName() + " , dice: " + valorImprimir + "ciclo: " + i);
		}
		System.out.println("Hilo: " + Thread.currentThread().getName() + " acabado");
		//aqui morira el hilo
	}
}
