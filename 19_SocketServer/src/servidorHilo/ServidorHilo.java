package servidorHilo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorHilo {
	
	public static final int PUERTO = 2001;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		ServerSocket servidor = null;
		
		try {
			servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress(IP_SERVER,PUERTO);
			//decimos al socket que escuche peticiones desde la IP y el puerto
			servidor.bind(direccion);

			System.out.println("Servidor creado por el puerto: " + PUERTO);
			System.out.println("Servidor creado por la IP Local: " + direccion.getAddress());
			
			while (true) {
				//esperamos a que llegue un cliente
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicación entrante");
				new HiloEscuchador(enchufeAlCliente);//abrimos un hilo nuevo y liberamos el hilo principal
			}
			
		} catch (IOException e) {
			System.err.println("main -> " + e.getMessage());
		} finally {
			if(servidor != null) {
				try {
					servidor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
