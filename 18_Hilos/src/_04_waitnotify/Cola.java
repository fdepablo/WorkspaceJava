package _04_waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	//Número máximo de Strings que acepto en la cola
	public final static int MAX_ELEMENTOS = 3;
	
	//Una cola es ideal para implementar este ejemplo
	//FIFO -> First In First Out 
	private Queue<String> cola = new LinkedList<>();
	
	public synchronized String getMensaje(){
		//Si la cola está vacia no debemos intentar sacar ningún elemento más
		//por lo que esperamos a que otro hilo ponga un elemento
		while(cola.size() == 0){
			try {
				wait();
				//El método wait(), a diferencia del sleep(), el hilo no 
				//se despertara pasado un tiempo, sino que se despertará 
				//cuando se le notifique mediante el método notify(). 
					
				//Además, liberamos el monitor del hilo, por lo que otro 
				//hilo que esté intentando entrar en algún método sincronizado 
				//podrá hacerlo.
					
				//Los métodos wait() y notify() solo se pueden invocar en 
				//un bloque o método sincronizado	
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Sacamos un elemento de la cola
		String cadena = cola.poll();
		//Despertamos a un hilo que esté en estado 'wait'
		notify();
		return cadena;
	}	
	
	public synchronized void addMensaje(String mensaje){
		//Si la cola está llena no debemos introducir ningún elemento más
		//por lo que esperamos a que otro hilo libere espacio
		while(cola.size() == MAX_ELEMENTOS){//3
			try {
				wait();			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Añadimos un elemento a la cola
		cola.offer(mensaje);
		//Despertamos a un hilo que esté en estado 'wait'
		notify();
	}
}