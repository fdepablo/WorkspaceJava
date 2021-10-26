package _04_waitnotify;

import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	
	//Numero maximo de strings que acepto en mi cola
	public final static int MAX_ELEMENTOS = 3;
	
	//Una cola es ideal para implementar este ejemplo
	//FIFO -> First in First out 
	private Queue<String> cola = new LinkedList<>();
	
	//Si no hubiera condicion de numero maximo de elementos con esto bastaria
	//Siempre que tengas un recurso compartido debes hacerte la pregunta de si dicho
	//recurso es thread safe
	public synchronized void addMensaje(String mensaje){

		//Si la cola esta llena no debemos introducir ningun elemento más
		while(cola.size() == MAX_ELEMENTOS){//3
			try {
			//A diferencia del sleep(), el hilo no se despertara pasado un tiempo,
			//sino que se despertaria cuando se le notifique mediante notify(). 
			//ADEMAS, liberamos el recurso por lo que otro hilo que intente 
			//entrar en algun metodo sincronizado podra hacerlo.
				
			//El metodo wait() y notify() solo se puede invocar en un bloque 
			//sincronizado 
				
			//El wait() debe estar dentro de un while, ya que cuando se 
			//ejecuta un notify() desde cualquier metodo podemos despertar
			//cualquier hilo en wait() que este dentro del objeto por lo 
			//que debemos realizar de nuevo la comprobacion de si la lista
			//esta llena para evitar problemas.
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Añadimos un elemento a la cola
		cola.offer(mensaje);
		//Notify, notificamos a todos los hilos que esten en estado wait que
		//despierten, pero solo se despertara 1 de los que esten en estado wait()
		notify();
	}
	
	public synchronized String getMensaje(){
		while(cola.size() == 0){
			try {
				//Cuando hacemos un wait() el hilo (consumidor) se queda esperando 
				//a que alquien le haga un notify() y acto seguido, libera el 
				//monitor del hilo.
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//Sacamos un elemento de la cola
		String s = cola.poll();
		//Notify, notificamos a todos los hilos que esten en estado wait que
		//despierten, pero solo se despertara 1 de los que esten en estado wait()
		notify();
		return s;
	}
	
}
