package modelo.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.entidad.Libro;

public class ServicioProxyLibro {
	
	// IP y Puerto a la que nos vamos a conectar
	public static final int PUERTO = 2021;
	public static final String IP_SERVER = "localhost";

	public Libro obtenerLibroPorIsbn(String isbn) {
		String textoEnvio = "1-" + isbn; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		Libro libro = deserializarLibro(textoRespuesta);
		return libro;
	}
	
	public Libro obtenerLibroPorTitulo(String titulo) {
		String textoEnvio = "2-" + titulo; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		Libro libro = deserializarLibro(textoRespuesta);
		return libro;
	}
	
	public List<Libro> obtenerLibroPorAutor(String autor) {
		String textoEnvio = "3-" + autor; 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		List<Libro> listaLibros = deserializarLibros(textoRespuesta);
		return listaLibros;
	}
	
	public boolean alta(Libro libro) {
		String textoEnvio = "4-" + libro.getISBN() + "-" + libro.getTitulo() +
				"-" + libro.getAutor() + "-" + libro.getPrecio(); 
		String textoRespuesta = conexionServidorRemoto(textoEnvio);
		return Boolean.parseBoolean(textoRespuesta);
	}
	
	
	private String conexionServidorRemoto(String textoEnvio) {
		InetSocketAddress direccionServidor = new InetSocketAddress(IP_SERVER, PUERTO);

		try (Scanner sc = new Scanner(System.in);){

			boolean continuar = true;				
				Socket socketAlServidor = new Socket();
				socketAlServidor.connect(direccionServidor);
				System.out.println("CLIENTE: Esperando a que el servidor acepte la conexión");
				System.out.println("CLIENTE: Conexion establecida... a " + IP_SERVER 
						+ " por el puerto " + PUERTO);	
				
				PrintStream salida = new PrintStream(socketAlServidor.getOutputStream());
				
				salida.println(textoEnvio);

				System.out.println("CLIENTE: Esperando al resultado del servidor...");	
				InputStreamReader entrada = new InputStreamReader(socketAlServidor.getInputStream());
				BufferedReader bf = new BufferedReader(entrada);
				String textoRespuesta = bf.readLine();				
					
				socketAlServidor.close();		
				
				return textoRespuesta;
		}catch (UnknownHostException e) {
			System.err.println("CLIENTE: No encuentro el servidor en la dirección" + IP_SERVER);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.err.println("CLIENTE: Error de entrada/salida");
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			System.err.println("CLIENTE: Error -> " + e);
			e.printStackTrace();
			return null;
		}
	}
	
	private Libro deserializarLibro(String sLibro) {
		String[] datos = sLibro.split("-");
		
		Libro libro = new Libro();
		libro.setISBN(datos[0]);
		libro.setTitulo(datos[1]);
		libro.setAutor(datos[2]);
		String sPrecio = datos[3];
		double precio = Double.parseDouble(sPrecio);
		libro.setPrecio(precio);
		
		return libro;
	}
	
	private List<Libro> deserializarLibros(String sListaLibros){
		List<Libro> listaLibros = new ArrayList<Libro>();
		String[] arrayLibros = sListaLibros.split("*");
		for(String libro : arrayLibros) {
			String[] sLibro = libro.split("-");
			Libro l = new Libro();
			l.setISBN(sLibro[0]);
			l.setTitulo(sLibro[1]);
			l.setAutor(sLibro[2]);
			l.setPrecio(Double.parseDouble(sLibro[3]));
			
			listaLibros.add(l);
		}
		
		return listaLibros;
	}
}
