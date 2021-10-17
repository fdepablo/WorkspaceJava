package cliente.hilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//En este ejemplo vamos a hacer que el cliente mande frases al servidor
//y el servidor tendrá que contar el numero de letras que tiene la frase
//La conexion se mantendra abierta hasta que el cliente mande la palabra
//"FIN" al servidor.

//En este caso se usara una misma conexion para todo el intercambio de mensajes
//del cliente al servidor
public class SocketClienteHilo {
	
	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2018;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE         ");
		System.out.println("-----------------------------------");

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		try (Scanner sc = new Scanner(System.in)){
						
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
			Socket socketAlServidor = new Socket();
			socketAlServidor.connect(direccionServidor);
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER + 
					" por el puerto " + PUERTO);

			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
			BufferedReader entradaBuffer = new BufferedReader(entrada);
			
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			
			String texto = "";
			boolean continuar = true;
			do {
				System.out.println("CLIENTE: Escribe mensaje (FIN para terminar): ");
				texto = sc.nextLine();//frase que vamos a mandar para contar				
				
				salida.println(texto);
				System.out.println("CLIENTE: Esperando respuesta ...... ");				
				String respuesta = entradaBuffer.readLine();
								
				if("OK".equalsIgnoreCase(respuesta)) {
					continuar = false;
				}else {
					System.out.println("CLIENTE: Servidor responde, numero de letras: " + respuesta);
				}				
			}while(continuar);
			//Cerramos la conexion
			socketAlServidor.close();
		} catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
		}
		
		System.out.println("CLIENTE: Fin del programa");
	}
	
}
