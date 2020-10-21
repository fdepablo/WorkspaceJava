package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
	
	//IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		
		//Socket es la clase que nos va a permitir comunicarnos con el servidor
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		Scanner sc = new Scanner(System.in);
		try {
			socketCliente = new Socket();
			socketCliente.connect(direccionServidor);
			System.out.println("Conexion establecida... a " + IP_SERVER + " por el puerto "
					+ PUERTO);
			
			entrada = new InputStreamReader(socketCliente.getInputStream());//entrada de datos del servidor (from)
			salida = new PrintStream(socketCliente.getOutputStream());//salida de datos al servidor(to)
			
			
			System.out.println("CLIENTE: Introduzca los numeros a sumar");
			String numero1 = sc.nextLine();//aqui se queda parada la app hasta que intro datos
			String numero2 = sc.nextLine();
			String operandos = numero1 + "-" + numero2;//3-4
			salida.println(operandos);//3-4
			
			//esta clase nos ayuda a leer datos del servidor linea a linea
			BufferedReader bf = new BufferedReader(entrada);
			//En la siguiente linea se va a quedar parado el hilo principal
			//de ejecución hasta que el servidor responda
			String resultado = bf.readLine();//Hola soy el servidor, te reenvio la suma:7
			
			System.out.println("CLIENTE: " + resultado);//resultado:7
			String[] arrayResultado = resultado.split(":");
			
			System.out.println("CLIENTE: El resultado de la suma es: " + arrayResultado[1]);//7
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		}finally {//ES MUYYY IMPORTANTE QUE EN LOS SOCKETS SIEMPRE SE CIERREN LAS CONEXIONES			
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
