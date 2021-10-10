package clienteHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteHilo {
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");

		Scanner lector = new Scanner(System.in);
		
		InputStreamReader entrada = null;
		PrintStream salida = null;
		Socket socketCliente = null;
		
		try {
			socketCliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 2001);
			System.out.println("Esperando a que el servidor acepte la conexión");

			socketCliente.connect(direccionServidor);
			System.out.println("Comunicación establecida con el servidor");

			entrada = new InputStreamReader(socketCliente.getInputStream());
			salida = new PrintStream(socketCliente.getOutputStream());
			BufferedReader entradaBuffer = new BufferedReader(entrada);
			
			String texto = "";
			while (!texto.equals("FIN")) {
				System.out.println("Escribe mensaje (FIN para terminar): ");
				texto = lector.nextLine();//mensaje leido del usuario

				salida.println(texto);
				System.out.println("Esperando respuesta ...... ");
				
				String respuesta = entradaBuffer.readLine();
				System.out.println("Servidor responde: " + respuesta);
			}
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		} finally {
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					socketCliente.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		lector.close();
		System.out.println("Comunicación cerrada");
	}
}
