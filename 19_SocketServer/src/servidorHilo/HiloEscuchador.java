package servidorHilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//Este hilo, manda al cliente lo que escriba hasta que ponga la palabra FIN
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
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;
		
		try {
			//salida del servidor
			salida = new PrintStream(enchufeAlCliente.getOutputStream());
			//entrada del servidor
			entrada = new InputStreamReader(enchufeAlCliente.getInputStream());
			//usamos un objeto que permita leer linea a linea
			entradaBuffer = new BufferedReader(entrada);
			
			String texto = "";
			boolean continuar = true;
			
			//procesaremos entradas hasta que el texto del cliente sea FIN
			while (continuar) {
				texto = entradaBuffer.readLine();
				if (texto.trim().equalsIgnoreCase("FIN")) {
					//nos despedimos del cliente
					salida.println("Hasta pronto, gracias por establecer conexión 😄");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");
					continuar = false;
				} else {
					//contamos las letras que tiene la frase que nos han mandado
					int numeroLetras = texto.trim().length();
					System.out.println(hilo.getName() + " dice: " + texto + " y tiene " 
							+ numeroLetras + " letras");
					//le mandamos la respuesta al cliente
					salida.println(("Tu mensaje tiene " + numeroLetras + " caracteres"));
				}
			}
		} catch (IOException e) {
			System.err.println("run -> " + e.getMessage());
		} finally {//muy importante cerrar las conexiones del socket
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					enchufeAlCliente.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
