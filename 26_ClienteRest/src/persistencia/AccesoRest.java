package persistencia;

import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import entidad.Persona;

public class AccesoRest {
	
	private static final String IP = "http://localhost:8080/27_ServidorRest/rest/personas";
	
	public String leerHTML() throws IOException{
		/*
		 * Aquí, estamos solicitando el servicio a través de una URL y 
		 * un objeto HttpURLConnection. La petición se envía a través 
		 * del método GET.
		 */
		URL objURL = new URL("http://localhost:8080/27_ServidorRest/rest/mensajeParametros/query?nombre=juan&apellidos=plaza");
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
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
		
		return respuesta;
	}
	
	public List<Persona> listarPersonas(String nombre) throws Exception {
		List<Persona> listaPersonas = null;
		String url = null;
		
		if(nombre == null) {
			url = IP;
		}else {
			url = IP + "?nombre=" + nombre;
		}
		
		System.out.println("Peticion a: " + url);
		
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		
		Scanner lector = new Scanner (conexion.getInputStream());
		
		String jsonRespuesta = lector.nextLine();
		
		Gson gson = new Gson();
		listaPersonas = gson.fromJson(jsonRespuesta, new TypeToken<List<Persona>>(){}.getType());
		
		lector.close();		
		
		return listaPersonas;
	}
	
	public Persona obtenerPersona(int id) throws Exception{
		String url = null;
		url = IP + "/" + id;
		
		System.out.println("Peticion a: " + url);
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("GET");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		Scanner lector = new Scanner (conexion.getInputStream());
		
		String respuesta = lector.nextLine();
		Gson gson = new Gson();
		
		Persona pRespuesta = gson.fromJson(respuesta, Persona.class);
		
		lector.close();		
		
		return pRespuesta;
	}
	
	public Persona altaPersona(Persona p) throws Exception{
		System.out.println("Peticion a: " + IP);
		URL objURL = new URL(IP);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("POST");
		conexion.setRequestProperty("Content-Type", "application/json");
		conexion.setDoOutput(true);//Permitimos mandar contenido en el body
				
		Gson gson = new Gson();
		String jsonAEnviar = gson.toJson(p);
		System.out.println("Json a enviar: " + jsonAEnviar);
				
		PrintStream salida = new PrintStream(conexion.getOutputStream());
		salida.println(jsonAEnviar);
		
		//Realizamos la solicitud al servidor
		conexion.connect();
				
		Scanner lector = new Scanner (conexion.getInputStream());
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		String jsonRespuesta = lector.nextLine();

		Persona pRespuesta = gson.fromJson(jsonRespuesta, Persona.class);
		
		lector.close();
		salida.close();
	
		return pRespuesta;
	}
	
	public Persona modificarPersona(Persona p, int id) throws Exception{
		String url = null;
		url = IP + "/" + id;
		
		System.out.println("Peticion a: " + IP);
		URL objURL = new URL(url);
		
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("PUT");
		conexion.setRequestProperty("Content-Type", "application/json");
		conexion.setDoOutput(true);//Permitimos mandar contenido en el body
				
		Gson gson = new Gson();
		String jsonAEnviar = gson.toJson(p);
		System.out.println("Json a enviar: " + jsonAEnviar);
				
		PrintStream salida = new PrintStream(conexion.getOutputStream());
		salida.println(jsonAEnviar);
		
		//Realizamos la solicitud al servidor
		conexion.connect();
				
		Scanner lector = new Scanner (conexion.getInputStream());
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		String jsonRespuesta = lector.nextLine();

		Persona pRespuesta = gson.fromJson(jsonRespuesta, Persona.class);
		
		lector.close();
		salida.close();
	
		return pRespuesta;
	}
	
	public int borrarPersonas(int id) throws Exception{
		String url = null;
		url = IP + "/" + id;
		
		System.out.println("Peticion a: " + url);
		URL objURL = new URL(url);
		HttpURLConnection conexion = (HttpURLConnection) objURL.openConnection();
		conexion.setRequestMethod("DELETE");
		
		//Realizamos la solicitud al servidor
		conexion.connect();
		
		int codigoHTTP = conexion.getResponseCode();
		System.out.println("Código: " + codigoHTTP);
		
		Scanner lector = new Scanner (conexion.getInputStream());
		
		String respuesta = lector.nextLine();
		
		int idRespuesta = Integer.parseInt(respuesta);
		
		lector.close();		
		
		return idRespuesta;
	}
}
