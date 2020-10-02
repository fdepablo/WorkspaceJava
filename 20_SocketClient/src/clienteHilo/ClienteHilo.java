package clienteHilo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteHilo {
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");

		Scanner lector = new Scanner(System.in);
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 2001);
			System.out.println("Esperando a que el servidor acepte la conexión");

			cliente.connect(direccionServidor);
			System.out.println("Comunicación establecida con el servidor");

			InputStream entrada = cliente.getInputStream();
			OutputStream salida = cliente.getOutputStream();

			String texto = "";
			while (!texto.equals("FIN")) {
				System.out.println("Escribe mensaje (FIN para terminar): ");
				texto = lector.nextLine();//mensaje leido del usuario
				salida.write(texto.getBytes());
				byte[] mensaje = new byte[100];
				System.out.println("Esperando respuesta ...... ");
				entrada.read(mensaje);
				System.out.println("Servidor responde: " + new String(mensaje));
			}

			entrada.close();
			salida.close();
			cliente.close();

			System.out.println("Comunicación cerrada");

		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		}

	}
}
