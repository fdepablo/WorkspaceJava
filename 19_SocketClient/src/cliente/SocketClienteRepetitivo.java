package cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//En este ejemplo vamos a ver como podemos recoger dos numeros desde una aplicacion
//cliente y mandarselos al sevidor para que nos devuelva una respuesta con 
//el resultado de la suma de ambos. El programa seguira mandando numeros al servidor
//hasta que el cliente decida parar el programa

//En este caso, cada peticion que se haga al cliente sera independiente y se hara
//con un objeto socket diferente, es decir, simulamos abrir y cerrar comunicación
//por cada peticion.
public class SocketClienteRepetitivo {

	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";

	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE         ");
		System.out.println("-----------------------------------");		

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in);){

			boolean continuar = true;			
			
			do {		
				System.out.println("Introduzca los numeros a sumar");
				String numero1 = sc.nextLine();
				String numero2 = sc.nextLine();
				String operandos = numero1 + "-" + numero2;	
				
				Socket socketAlServidor = new Socket();
				socketAlServidor.connect(direccionServidor);
				System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
				System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
						+ " por el puerto " + PUERTO);	
				
				PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
				salida.println(operandos);

				System.out.println("CLIENTE: Esperando al resultado del servidor...");	
				InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String resultado = bf.readLine();				
				System.out.println("CLIENTE: El resultado de la suma es: " + resultado);
				
				System.out.println("CLIENTE: Quiere continuar? S/N");
				String sContinuar = sc.nextLine();
				if (sContinuar.equalsIgnoreCase("n")) {
					continuar = false;
				}
				
				//Cerramos el socket para cerrar las conexiones.
				//Si cerramos un socket se cierran los inputStream y outputStream
				//que tenga asociados
				socketAlServidor.close();
			} while (continuar);			
		}catch (UnknownHostException e) {
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
