package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws InterruptedException {
		//Este objeto es el que abrirá un puerto
		ServerSocket servidorSocket = null;
		PrintStream salida = null;
		InputStreamReader entrada = null;
		Socket socketConexion = null;
		
		try {
			servidorSocket = new ServerSocket(2017);//puerto por el que escuchamos a los clientes
			//estamos continuamente escuchando 
			while(true){
				//Lo ideal seria sacar esto en un hilo
				System.out.println("SERVIDOR: Esperando peticion...");
				//Cuando la conexion es establecida, se crea un socket en 
				//para llevar la comunicacion
				socketConexion = servidorSocket.accept();//Se parará el programa, hasta que entre la peticion de un cliente
				
				entrada = new InputStreamReader(socketConexion.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String stringRecibido = bf.readLine();//3-4
				System.out.println("SERVIDOR: Me ha llegado del cliente: " + stringRecibido);
				String[] operadores = stringRecibido.split("-");
				int iNumero1 = Integer.parseInt(operadores[0]);//3
				int iNumero2 = Integer.parseInt(operadores[1]);//4
				int resultado = iNumero1 + iNumero2;//7 
				//Thread.sleep(10000);//simulamos que tardamos un tiempo en calcular
				salida = new PrintStream(socketConexion.getOutputStream());
				salida.println("resultado:" + resultado);
				
			}
		} catch (IOException excepcion) {
			System.out.println(excepcion);
		}finally {
			try {
				if(salida != null && entrada != null){
					salida.close();
					entrada.close();
					socketConexion.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
