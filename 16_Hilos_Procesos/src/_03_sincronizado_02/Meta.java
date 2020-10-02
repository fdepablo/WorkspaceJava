package _03_sincronizado_02;

import java.util.ArrayList;
import java.util.List;

//Esta clase sera el recurso compartido por los tres caballos
public class Meta {
	private List<Caballo> orden = new ArrayList<Caballo>();
	
	//Tenemos que conseguir que la operacion sea atomica con el 
	// synchronized. Sino al final del metodo saldria que todos los 
	//caballos han llegado en la posicion 3
	public synchronized void apuntarCaballo(Caballo caballo){
		orden.add(caballo);
		
		//Simulamos problemas de sincronizacion de hilos
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(caballo.getNombre()+" pos.:"+orden.size());
	}
	
	//Tambien podemos usar bloques sincronizados en lugar de metodos
	//sincronizados
	public void apuntarCaballo2(Caballo caballo){
		
		synchronized (this) {
			orden.add(caballo);
		}
		
		//Simulamos problemas de sincronizacion de hilos
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(caballo.getNombre()+" pos.:"+orden.size());
	}
}
