package servidorHilo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HiloEscuchador implements Runnable{
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;
	
	
	public HiloEscuchador(Socket cliente) {
		numCliente++;
		hilo = new Thread(this, "Cliente_"+numCliente);
		this.enchufeAlCliente = cliente;
		hilo.start();
	}
	
	@Override
	public void run() {
		System.out.println("Estableciendo comunicación con " + hilo.getName());
		try {
			InputStream entrada = enchufeAlCliente.getInputStream();
			OutputStream salida = enchufeAlCliente.getOutputStream();
			String texto = "";
			while (!texto.trim().equals("FIN")) {
				byte[] mensaje = new byte[100];
				entrada.read(mensaje);
				texto = new String(mensaje);
				if (texto.trim().equals("FIN")) {
					salida.write("Hasta pronto, gracias por establecer conexión".getBytes());
					System.out.println(hilo.getName()+" ha cerrado la comunicación");
				} else {
					System.out.println(hilo.getName() + " dice: " + texto);
					salida.write(("Tu mensaje tiene " + texto.trim().length() + " caracteres").getBytes());
				}
			}
			entrada.close();
			salida.close();
			enchufeAlCliente.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
