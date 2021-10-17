package servidor.hilo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//En este caso, vamos a abrir un hilo por cada peticion que haga el servidor
//para así poder procesar varias peticiones simultaneas de diferentes clientes
public class SocketServidorHilo {
	
	public static final int PUERTO = 2018;
	
	public static void main(String[] args) {
		System.out.println("      APLICACIÓN DE SERVIDOR CON HILOS     ");
		System.out.println("-------------------------------------------");		
		
		int peticion = 0;
		
		try (ServerSocket servidor = new ServerSocket()){			
			InetSocketAddress direccion = new InetSocketAddress(PUERTO);
			servidor.bind(direccion);

			System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
			
			while (true) {
				//Por cada peticion de cliente aceptada se me crea un objeto socket diferente
				Socket socketAlCliente = servidor.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				//Abrimos un hilo nuevo y liberamos el hilo principal para que pueda
				//recibir peticiones de otros clientes
				new HiloContadorLetras(socketAlCliente);
			}			
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error");
			e.printStackTrace();
		}
	}
}
