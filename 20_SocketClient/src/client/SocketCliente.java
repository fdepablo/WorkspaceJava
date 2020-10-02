package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {
	public static void main(String[] args) {
		//Socket es la clase que nos va a permitir comunicarnos con el servidor
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		String ipServidor = "127.0.0.1";//ip a la nos conectamos
		int puertoServidor = 2017;//puerto por el que nos conectamos al servidor

		try {
			socketCliente = new Socket(ipServidor, puertoServidor);
			entrada = new InputStreamReader(socketCliente.getInputStream());//entrada de datos del servidor (from)
			salida = new PrintStream(socketCliente.getOutputStream());//salida de datos al servidor(to)
			
			Scanner sc = new Scanner(System.in);
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
			System.out.println("CLIENTE: " + resultado);//mostramos el resultado de la suma
			String[] arrayResultado = resultado.split(":");
			System.out.println("CLIENTE: El resultado de la suma es: " + arrayResultado[1]);
		} catch (Exception e) {
			System.err.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
