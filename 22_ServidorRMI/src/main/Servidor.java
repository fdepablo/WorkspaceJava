package main;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import beans.Cancion;
import negocio.MusicaRMI;

public class Servidor {
	public static void main(String[] args) {
		String host;
		int puerto = 5055;
		try {
			/*
			 * En esta línea averiguamos programáticamente la dirección IP de 
			 * la red local de la máquina que aloja el programa servidor. 
			 * Dicha dirección IP la guardamos en la variable host. 
			 * También podríamos haber asignado directamente la cadena "localhost". 
			 * 
			 * El método getHostAddress() puede desencadenar una excepción de tipo 
			 * UnknownHostException si por alguna circunstancia no puede averiguar 
			 * la dirección IP local.
			 * 
			 * Esto solo se usa para mostrar en el log de arranque la ip de nuestro
			 * servidor
			 */
			host = InetAddress.getLocalHost().getHostAddress();//localhost
		} catch (UnknownHostException e) {
			System.out.println("No se ha podido obtener la dirección IP");
			System.out.println(e.getMessage());
			return;
		}
		
		try {
			/*
			 * Con esta línea estamos creando el registro de objetos remotos. 
			 * Los objetos que se inscriban en dicho registro quedarán a 
			 * disposición de los clientes a partir de la dirección IP del 
			 * servidor y el número de puerto especificado en el argumento del 
			 * método createRegistry. 
			 * Observa que más arriba hemos establecido la variable puerto con 
			 * el valor 5055.
			 */
			Registry registro = LocateRegistry.createRegistry(puerto);
			/*
			 * Aquí creamos el objeto que deseamos compartir y que conforma 
			 * la lógica del servicio prestado.
			 */
			MusicaRMI musica = new MusicaRMI();
			
			/*
			 * Nuestro registro de objetos remotos dispone del método rebind, 
			 * que nos permitirá inscribir el nuevo objeto dentro de él para 
			 * que los clientes puedan obtener el stub. Como primer argumento 
			 * indicamos un identificador para el nuevo objeto. Los clientes que 
			 * deseen acceder al objeto remoto necesitarán conocer este identificador.
			 */
			registro.rebind("miMusica", musica);
			
			System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
		} catch (RemoteException e) {
			System.out.println("No se ha podido registrar el servicio");
			System.out.println(e.getMessage());
		}
		/*
		 * Tambien seria posible eliminar el objeto programaticamente
		 * mediante la siguiente linea
		 * UnicastRemoteObject.unexportObject(musica, true);
		 */
	}
}
