package main;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		
		/*
		 * Aquí, estamos solicitando el servicio a través de una URL y 
		 * un objeto HttpURLConnection. La petición se envía a través 
		 * del método GET.
		 */
		URL objURL = new URL("http://localhost:8080/27_ServidorRest/rest/mensajeParametros/query?nombre=juan&apellidos=plaza");
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		/*
		 * Obtenemos el código HTTP de la petición y lo mostramos en pantalla.
		 * Salvo que ocurra algún error, el código será 200 (OK).
		 */
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		/*
		 * El método conexion.getInputStream() nos devuelve el flujo de datos 
		 * que necesitaremos para leer el mensaje del servidor. 
		 * Dicho flujo de datos se lo pasamos a un objeto Scanner, 
		 * que facilitará enormemente la lectura.
		 */
		Scanner lector = new Scanner (conexion.getInputStream());
		String respuesta = "";
		while (lector.hasNextLine()) {
			respuesta = respuesta.concat(lector.nextLine());
		}
		
		lector.close();
		
		System.out.println(respuesta);
	}
}
