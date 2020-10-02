package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClientRepetitivo {
	public static void main(String[] args) {
		Socket socketCliente = null;
		InputStreamReader entrada = null;
		PrintStream salida = null;

		String ipServidor = "127.0.0.1";
		int puertoServidor = 2017;
		// nos conectamos al localhost a traves de esta dirección IP

		try {
			
			Scanner sc = new Scanner(System.in);
			boolean continuar = true;
			do {
				socketCliente = new Socket(ipServidor, puertoServidor);
				// asignamos este numero de puerto
				entrada = new InputStreamReader(socketCliente.getInputStream());
				// será lo que enviaremos al servidor
				salida = new PrintStream(socketCliente.getOutputStream());
				// será lo que nos devuelva el servidor
				
				System.out.println("Introduzca los numeros a sumar");
				String numero1 = sc.nextLine();
				String numero2 = sc.nextLine();
				String operandos = numero1 + "-" + numero2;
				salida.println(operandos);
							
				BufferedReader bf = new BufferedReader(entrada);
				//Esperamos aqui a que responda el servidor
				String linea_recibida = bf.readLine();
				System.out.println("CLIENTE: El servidor me ha respondido: " + linea_recibida);
				System.out.println("Quiere continuar? S/N");
				String sContinuar = sc.nextLine();
				if(sContinuar.equalsIgnoreCase("n")) {
					continuar = false;
				}
			}while(continuar);
		} catch (UnknownHostException excepcion) {
			System.err.println("No encuentro el servidor en la dirección" + ipServidor);
		} catch (IOException excepcion) {
			System.err.println("Error de entrada/salida");
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}finally {			
			try {
				salida.close();
				entrada.close();
				socketCliente.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
