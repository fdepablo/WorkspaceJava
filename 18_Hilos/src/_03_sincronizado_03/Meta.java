package _03_sincronizado_03;

import java.util.ArrayList;
import java.util.List;

//Esta clase será el recurso compartido por los tres caballos
public class Meta {
	//Esta lista va a llevar el orden en el que llegan los caballos
	private List<Caballo> orden = new ArrayList<Caballo>();
	
	public List<Caballo> getLista(){
		return orden;
	}
	
	// Tenemos que conseguir que solo un hilo pueda entrar a la vez con 
	// la palabra 'synchronized'. Sino al final del método saldría que  
	// todos los caballos han llegado en la posicion 3
	public synchronized void apuntarCaballo(Caballo caballo){
		System.out.println("El caballo " + caballo.getNombre() + 
				" llego a la meta!");
		
		orden.add(caballo);
		
		//Simulamos una tarea de larga duración, como por ejemplo que tenemos
		//que guardar la información en una base de datos remota o acceder
		//a un servidor web remoto, que tarde por ejemplo 2 segundos en procesar
		//la información del caballo
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(caballo.getNombre()+" pos.:"+orden.size());
	}
	
	//También podemos usar bloques sincronizados en lugar de métodos
	//sincronizados. Los métodos sincronizados bloquean todo el método,
	//mientras que los bloques sincronizados solo sincronizan dicho bloque
	//y no el método entero.
	public void apuntarCaballo2(Caballo caballo){
		
		//Los bloques sincronizados empiezan con 'synchronized'
		synchronized (this) {
			orden.add(caballo);
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(caballo.getNombre()+" pos.:"+orden.size());
	}
}
