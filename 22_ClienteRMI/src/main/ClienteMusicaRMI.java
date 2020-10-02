package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import beans.Cancion;
import interfaces.MusicaInterfaceRMI;

public class ClienteMusicaRMI {
	public static void main(String[] args) {
        Registry registry;
        Scanner lector = new Scanner(System.in);
		try {
			//Aqui la IP debera ser la IP del servidor
			registry = LocateRegistry.getRegistry("192.168.0.14", 5055);
			System.out.println("Hemos obtenido el registro");
			//Una vez obtenido acceso al registro, hay que obtener el stub a partir del identificador 
			//del objeto suministrado en el programa servidor.
			//lookup nos devuelve un tipo de objeto Remote, por lo que tendremos
			//que castearlo a un objeto de la interface MusicaInterfaceRMI
			//para poder utilizar sus metodos
			MusicaInterfaceRMI canciones = (MusicaInterfaceRMI) registry.lookup("miMusica"); 
			System.out.println("Hemos obtenido el objeto remoto (STUB)");
			System.out.println(); // Retorno de carro.
			
			String buscado;
			String opcion;
			
			do {
				escribirMenu(); 
				opcion = lector.nextLine().toUpperCase();
				switch (opcion) {
					case "T":
						System.out.println("Escribe título canción: ");
						buscado = lector.nextLine();
						String titulo = canciones.buscarTitulo(buscado);//utilizo el objeto stub para mandar
																	//mensajes al objeto real que esta en el 
																	//servidor
						if(!titulo.isEmpty())
							System.out.println(titulo);
						else
							System.out.println("No se ha encontrado un carallo");
						break;
					case "B":
						System.out.println("Escribe nombre banda: ");
						buscado = lector.nextLine();
						System.out.println(canciones.buscarBanda(buscado));//SIGUE SIENDO EL OBJETO STUB
						break;
					case "A":
						System.out.println("Escribe nombre álbum: ");
						buscado = lector.nextLine();
						System.out.println(canciones.buscarAlbum(buscado));
						break;
					case "P":
						System.out.println("Escribe año de producción: ");
						buscado = lector.nextLine();
						int a = Integer.parseInt(buscado);
						System.out.println(canciones.buscarProducido(a));
						break;
					case "I":
						System.out.println("Escribe el id al buscar: ");
						buscado = lector.nextLine();
						int id = Integer.parseInt(buscado);
						Cancion c = canciones.buscarCancion(id);
						System.out.println(c);
						//System.out.println(c.getTitulo() + c.getAlbum());//puedo trabajar con objeto
						break;
					case "F":
						System.out.println("Programa finalizado");
						break;
					default:
						System.out.println("Opción incorrecta");
				}
				
				
			} while (!opcion.equals("F"));
			 
			
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}
	
	private static void escribirMenu() {
		System.out.println();
		System.out.println("Búsqueda de canciones");
		System.out.println("--------------------------");
		System.out.println("T = Título");
		System.out.println("B = Banda");
		System.out.println("A = Álbum");
		System.out.println("P = Año producción");
		System.out.println("I = ID");
		System.out.println("F = Terminar programa");
		System.out.println("--------------------------");
		System.out.println("¿Qué opción eliges?");
	}
}
