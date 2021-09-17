package _02_demonio;

/*
 * Se entiende como demonio aquel programa que esta ejecutandose continuamente
 * sin parar
 */
public class Demonio implements Runnable {

	private boolean encendido = true;
	
	@Override
	public void run() {
		System.out.println("Arrancado Demonio: " + Thread.currentThread().getName());
		int contador = 0;
		//Estrictamente hablando, para que fuera un demonio autentico, el
		//siguiente while tendria que ser de la forma "while(true)" para hacerlo
		//bucle infinito. En este caso le ponemos un booleano para poder pararlo
		//mandandole una señal con el metodo "apagarDemonio" de más abajo
		while(encendido){
			System.out.println("Demonio: " + Thread.currentThread().getName()+ " dice: " + contador);
			contador++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Domonio parado");
	}
	
	public void apagarDemonio(){
		this.encendido = false;
		System.out.println("Apagando demonio...");
	}

}
