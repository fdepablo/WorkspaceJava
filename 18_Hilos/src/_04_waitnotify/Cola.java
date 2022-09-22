package _04_waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	//Número máximo de Strings que acepto en mi cola
	public final static int MAX_ELEMENTOS = 3;
	
	//Una cola es ideal para implementar este ejemplo
	//FIFO -> First in First out 
	private Queue<String> cola = new LinkedList<>();
	
	//Si no hubiera condición de numero máximo de elementos con esto bastaría
	//Siempre que tengas un recurso compartido debes hacerte la pregunta de si dicho
	//recurso es ‘thread safe’
	public synchronized void addMensaje(String mensaje){

		//Si la cola está llena no debemos introducir ningún elemento más
		while(cola.size() == MAX_ELEMENTOS){//3
			try {
			//A diferencia del sleep(), el hilo no se despertara pasado un tiempo,
			//sino que se despertaría cuando se le notifique mediante notify(). 
			//ADEMAS, liberamos el recurso por lo que otro hilo que intente 
			//entrar en algún método sincronizado podrá hacerlo.
				
			//El metodo ‘wait()’ y ‘notify()’ solo se puede invocar en un bloque 
			//sincronizado 
				
			//El wait() debe estar dentro de un while, ya que cuando se 
			//ejecuta un notify() desde cualquier metodo podemos despertar
			//cualquier hilo en wait() que este dentro del objeto por lo 
			//que debemos realizar de nuevo la comprobación de si la lista
			//está llena para evitar problemas.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Añadimos un elemento a la cola
		cola.offer(mensaje);
		//Con ‘notify()’, notificamos a todos los hilos que estén en estado wait que
		//despierten, pero solo se despertara 1 de los que estén en estado wait()
		notify();
	}
	
	public synchronized String getMensaje(){
		while(cola.size() == 0){
			try {
				//Cuando hacemos un wait() el hilo (consumidor) se queda esperando 
				//a que alguien le haga un notify() y acto seguido, libera el 
				//monitor del hilo.
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Sacamos un elemento de la cola
		String s = cola.poll();
		// Con ‘notify()’, notificamos a todos los hilos que estén en estado wait que
		//despierten, pero solo se despertara 1 de los que estén en estado wait()
		notify();
		return s;
	}	
}