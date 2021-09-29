package _03_sincronizado_02;

import java.util.ArrayList;
import java.util.List;

//Esta clase sera el recurso compartido por los tres caballos
public class Meta {
	//Esta lista va a llevar el orden en el que llegan los caballos
	private List<Caballo> orden = new ArrayList<Caballo>();
	
	public List<Caballo> getLista(){
		return orden;
	}
	
	// Tenemos que conseguir que la operacion sea atomica con el 
	// synchronized. Sino al final del metodo saldria que todos los 
	// caballos han llegado en la posicion 3
	public synchronized void apuntarCaballo(Caballo caballo){
		System.out.println("El caballo " + caballo.getNombre() + " llego en : " + caballo.getTiempo().getTime());
		orden.add(caballo);
		
		//Simulamos una tarea de larga duracion, como por ejemplo que tenemos
		//que guardar la información en una base de datos remota o acceder
		//a un servidor web remoto, de por ejemplo 2 segundos para mandar
		//informacion del caballo
		try {
			Thread.sleep(2000);//babieca rocinante
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(caballo.getNombre()+" pos.:"+orden.size());
	}
	
	//Tambien podemos usar bloques sincronizados en lugar de metodos
	//sincronizados. Los metodos sincronizados bloquean todo el metodo,
	//mientras que los bloques sincronizados solo sincronizan dicho bloque
	//y no el metodo entero.
	public void apuntarCaballo2(Caballo caballo){
		
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
