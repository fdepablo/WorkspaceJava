package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Libro;
import modelo.negocio.HiloLibro;
import modelo.persistencia.DaoLibro;

public class SocketServidor {
	
	public static final int PUERTO = 2021;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDORA DE LIBROS     ");
		System.out.println("--------------------------------------------");
		
		//Instanciamos el Dao y la lista de libros al principio de la app
		DaoLibro daoLibro = instanciarDao();		
		
		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketAlCliente = null;		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);

		try (ServerSocket serverSocket = new ServerSocket()){			

			serverSocket.bind(direccion);
			
			int peticion = 0;
			
			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				
				//En este punto, se parara el programa, hasta que entre la peticion de 
				//un cliente, y sera en ese momento cuando se cree un objeto Socket
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				HiloLibro hl = new HiloLibro(daoLibro, socketAlCliente);
				hl.start();				
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA

	private static DaoLibro instanciarDao() {
		DaoLibro daoLibro = new DaoLibro();
		List<Libro> listaLibros = new ArrayList<>();
		daoLibro.setListaLibros(listaLibros);
;		return daoLibro;
	}
}
