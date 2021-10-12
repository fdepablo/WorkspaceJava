package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServidor {
	
	public static final int PUERTO = 2017;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("      APLICACIÓN DE SERVIDOR      ");
		System.out.println("----------------------------------");
		
		//ServidorSocket -> Este objeto es el que estará escuchando peticiones por un puerto
		//y creara un objeto socket por cada peticion
		
		//Entrada de datos. Es el canal de entrada del servidor, es decir, el canal por 
		//el cual el cliente nos va a mandar la información.
		InputStreamReader entrada = null;
		//Salida de datos. Es el canal de salida del servidor, es decir, el canal por 
		//el cual vamos a enviar información al cliente.
		PrintStream salida = null;
		
		//Notese como ahora:
		//1. El PrintStream del cliente es el InputStreamReader del servidor
		//2. El PrintStream del servidor es el InputStreamReader del cliente
		
		//Socket -> es la clase que nos va a permitir comunicarnos con el cliente,
		//en este caso no lo crearemos nosotros, sino que sera el SocketServer quien
		//lo cree cuando acepte una peticion de un cliente.
		Socket socketAlCliente = null;
		
		InetSocketAddress direccion = new InetSocketAddress(PUERTO);
		
		//En este caso no podemos hacer la declaracion try-with-resources como antes
		//ya que el servidor es un hilo que no para nunca y por cada peticion
		//crea un nuevo objeto Socket a partir del objeto ServerSocket, es decir,
		//sera el objeto ServerSocket el que nos crerara el objeto Socket por nosostros
		try (ServerSocket serverSocket = new ServerSocket()){			
			
			//Decimos al server socket que escuche peticiones desde el puerto
			//que hayamos establecido
			serverSocket.bind(direccion);
			
			//Vamos a llevar la cuenta del numero de peticiones que nos llegan
			int peticion = 0;
			
			//Estamos continuamente escuchando, es lo normal dentro del comportamiento
			//de un servidor, un programa que no para nunca
			while(true){		
				
				System.out.println("SERVIDOR: Esperando peticion por el puerto " + PUERTO);
				
				//En este punto, se parara el programa, hasta que entre la peticion de 
				//un cliente, y sera en ese momento cuando se cree un objeto Socket
				socketAlCliente = serverSocket.accept();
				System.out.println("SERVIDOR: peticion numero " + ++peticion + " recibida");
				
				entrada = new InputStreamReader(socketAlCliente.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
								
				//El servidor se quedaría aquí parado hasta que el cliente nos mande
				//informacion, es decir, cuando haga un salida.println(INFORMACION);				
				String stringRecibido = bf.readLine();//3-4
				
				//Hay que tener en cuenta que toda comunicacion entre cliente y servidor
				//esta en formato de cadena de texto
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				//Como sabemos que el cliente nos envia un 3-7, hacemos un split por "-"
				//para obtener la información.
				String[] operadores = stringRecibido.split("-");
				int iNumero1 = Integer.parseInt(operadores[0]);//3
				int iNumero2 = Integer.parseInt(operadores[1]);//4
				
				//Hay que tener en cuenta que es posible que los servidores tarden en responder
				//Thread.sleep(15000);
				
				//Es en este momento cuando calculamos la suma
				int resultado = iNumero1 + iNumero2;//7 
				System.out.println("SERVIDOR: El calculo de los numeros es: " + resultado);
								
				//Mandamos el resultado al cliente
				salida = new PrintStream(socketAlCliente.getOutputStream());
				salida.println(resultado);	
				
				//Si hemos llegado hasta aqui, cerramos las conexiones
				socketAlCliente.close();
			}
		} catch (IOException e) {
			System.err.println("SERVIDOR: Error de entrada/salida");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("SERVIDOR: Error -> " + e);
			e.printStackTrace();
		}
	}//FIN DEL PROGRAMA
}
