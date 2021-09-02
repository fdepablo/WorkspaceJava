package negocio;

import java.util.LinkedList;
import java.util.Queue;

import entidad.Coche;

public class Cola {
	
	public final static int MAX_ELEMENTOS = 3;
	
	//Una lista circular es ideal para implementar este ejemplo
	//FIFO
	private Queue<Coche> cola = new LinkedList<>();
	
	//Si no hubiera condicion de numero maximo de elementos con esto bastaria
	//Siempre que tengas un recurso compartido debes hacerte la pregunta de si dicho
	//recurso es thread safe
	public synchronized void addMensaje(Coche coche){
		//Esto así solo no funcionaria, ya que si llega un productor y la cola esta 
		//llena
		//perderiamos un mensaje, debemos implementar una cola activa
		/*if(cola.size() < MAX_ELEMENTOS){
			cola.offer(mensaje);
		}*/
		//Si la cola esta llena no debemos introducir ningun elemento más
		while(cola.size() == MAX_ELEMENTOS){//3
			try {
				//A diferencia del sleep no se activará pasado un tiempo, sino que se
				//activaria cuando se le notifique, ADEMAS, liberamos el recurso por 
				//lo que otro hilo que intente entrar en addMensaje podra hacerlo. 
				//wait() solo se puede ejecutar en un bloque sincronizado y debe de 
				//estar dentro de un while ya que cuando hacemos un notify desde 
				//este metodo no solo despertamos a los hilos del metodo
				//getMensaje, sino que tambien despertamos a los productores que esten 
				//en este wait, por lo tanto un if no nos serviria ya que no se quedaria 
				//en bucle
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Add un elemento a la cola
		cola.offer(coche);
		//Notify, notificamos a todos los hilos que esten en estado wait que
		//despierten(tanto los de addMensaje como los de getMensaje)
		notify();
	}
	
	public synchronized Coche getMensaje(){
		Coche s = null;
		while(cola.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Sacamos un elemento de la cola
		s = cola.poll();
		//Todos los hilos en estado wait asociados al objeto pasan a estado "elegido" 
		//y cualquier hilo puede ser elegido de los que estan notificados 
		//al azar
		//El notifyAll saca a todos los hilos sin importar a que recurso(objeto) esta 
		//asociado, un ejemplo puede ser
		//el problema de los filosofos y los tenedores
		notify();
		return s;
	}
	
}
