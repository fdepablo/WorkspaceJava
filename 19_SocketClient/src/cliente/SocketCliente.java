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
//el resultado de la suma de ambos.
public class SocketCliente {
	
	//IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2017;
	public static final String IP_SERVER = "localhost";
	
	public static void main(String[] args) {
		System.out.println("        APLICACIÓN CLIENTE         ");
		System.out.println("-----------------------------------");
		
		//Socket -> es la clase que nos va a permitir comunicarnos con el servidor

		//InputStreamReader entrada -> Entrada de datos. Es el canal de entrada del 
		//cliente, es decir, el canal por el cual el servidor nos va a mandar la 
		//información.

		//PrintStream salida -> Salida de datos. Es el canal de salida del cliente, 
		//es decir, el canal por el cual vamos a enviar información al servidor.		

		//En este objeto vamos a encapsular la IP y el puerto al que nos vamos a conectar
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);
		
		//Usaremos la declaracion try-with-resources, esta declaración nos asegura que
		//todos los objetos que declaremos e instanciemos dentro del bloque try, serán
		//cerrados cuando salgan del bloque try-catch. Es muy util parar ahorranos codigo
		//ya que sino deberíamos cerrarlos (ejecutar su metodo close()), dentro del bloque
		//finally, creando muchas más lineas para ello.
		try (Scanner sc = new Scanner(System.in);
			Socket socketAlServidor = new Socket()){
					
			//Pedimos al usuario los numeros a sumar
			System.out.println("CLIENTE: Introduzca los numeros a sumar");
			String numero1 = sc.nextLine();//supongamos el numero 3
			String numero2 = sc.nextLine();//supongamos el numero 4
			
			//En este caso voy a establecer que mi comunicación entre el cliente y el
			//servidor va a ser que le mando los dos numeros separados por un "-"
			//para luego en el servidor obtener ambmos numeros mediante el 
			//metodo split() de la clase String
			String operandos = numero1 + "-" + numero2;//3-4
			
			//Observese como no conviertos los datos a enteros, ya que cuando
			//se mandan a traves de un socket se mandan SIEMPRE en formato cadena
			
			//Establecemos la conexión
			System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
			socketAlServidor.connect(direccionServidor);			
			System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
					+ " por el puerto " + PUERTO);		
			
			//Creamos el objeto que nos permite mandar informacion al servidor
			PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
			//Mandamos la información por el Stream
			salida.println(operandos);//3-4
			
			//Creamos el objeto que nos va a permitir leer la salida del servidor
			InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
					
			//Esta clase nos ayuda a leer datos del servidor linea a linea en vez de 
			//caracter a caracter como la clase InputStreamReader
			BufferedReader bf = new BufferedReader(entrada);
			
			System.out.println("CLIENTE: Esperando al resultado del servidor...");
			//En la siguiente linea se va a quedar parado el hilo principal
			//de ejecución hasta que el servidor responda, es decir haga un println
			String resultado = bf.readLine();//7
				
			System.out.println("CLIENTE: El resultado de la suma es: " + resultado);//7
			
			//Nota, no cierro ni "entrada" ni "salida" ya que se encarga el objeto
			//socket cuando salgamos del bloque try-catch
		} catch (UnknownHostException e) {
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
