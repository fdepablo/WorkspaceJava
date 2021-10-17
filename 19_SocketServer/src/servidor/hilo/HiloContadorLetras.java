package servidor.hilo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

//Este hilo va a contar el numero de letras que tiene la frase que le manda el 
//cliente.

//La conexion se mantendra abierta hasta que el cliente mande la palabra
//"FIN" al servidor.

//Recibe el socket que abre el servidor con el cliente y con el que
//mantendra la conversacion
public class HiloContadorLetras implements Runnable{
	private Thread hilo;
	private static int numCliente = 0;
	private Socket socketAlCliente;	
	
	public HiloContadorLetras(Socket socketAlCliente) {
		numCliente++;
		hilo = new Thread(this, "Cliente_"+numCliente);
		this.socketAlCliente = socketAlCliente;
		hilo.start();
	}
	
	@Override
	public void run() {
		System.out.println("Estableciendo comunicacion con " + hilo.getName());
		PrintStream salida = null;
		InputStreamReader entrada = null;
		BufferedReader entradaBuffer = null;
		
		try {
			//Salida del servidor al cliente
			salida = new PrintStream(socketAlCliente.getOutputStream());
			//Entrada del servidor al cliente
			entrada = new InputStreamReader(socketAlCliente.getInputStream());
			entradaBuffer = new BufferedReader(entrada);
			
			String texto = "";
			boolean continuar = true;
			
			//Procesaremos entradas hasta que el texto del cliente sea FIN
			while (continuar) {
				texto = entradaBuffer.readLine();
				//trim() es un metodo que quita los espacios en blanco del principio
				//y del final
				if (texto.trim().equalsIgnoreCase("FIN")) {
					//Mandamos la señal de "0" para que el cliente sepa que vamos a cortar
					//la comunicacion
					salida.println("OK");
					System.out.println(hilo.getName() + " ha cerrado la comunicacion");
					continuar = false;
				} else {
					//Contamos las letras que tiene la frase que nos han mandado
					int numeroLetras = texto.trim().length();
					System.out.println(hilo.getName() + " dice: " + texto + " y tiene " 
							+ numeroLetras + " letras");
					//Le mandamos la respuesta al cliente
					salida.println(numeroLetras);
				}
			}
			//Cerramos el socket
			socketAlCliente.close();
			//Notese que si no cerramos el socket ni en el servidor ni en el cliente, mantendremos
			//la comunicacion abierta
		} catch (IOException e) {
			System.err.println("HiloContadorLetras: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("HiloContadorLetras: Error");
			e.printStackTrace();
		}
	}
}
