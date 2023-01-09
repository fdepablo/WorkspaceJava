package _04_hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class _01_ResumenHash {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		//Creamos el mensaje del cual queremos crear su resumen.
		//En este caso quiero "hashear" una serie de canciones.
		//Notese que lo pasamos a bytes ya que se necesita que la 
		//información este así para poder crear su resumen hash.
		byte[] cancion1 = "Bohemian Rhapsody".getBytes();
		byte[] cancion2 = "Imagine".getBytes();
		byte[] cancion3 = "We Are the Champions".getBytes();
		byte[] cancion4 = "Hotel California".getBytes();
		
		//Creamos un objeto MessageDigest a través del método estático 
		//getInstance() al que se le pasa el tipo de algoritmo que vamos a 
		//utilizar. 
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(cancion1);
		md.update(cancion2);
		md.update(cancion3);
		md.update(cancion4);
		
		//El último paso será ejecutar el método "digest()" de nuestro 
		//objeto MessageDigest para obtener el resumen, que también 
		//será una cadena de bytes.
		System.out.println("Creando el resumen hash...");
		byte[] resumen = md.digest();
		String mensaje = new String(resumen);
		System.out.println("Resumen hash: " + mensaje);
		
		//Podemos pasarlo a la codificación BASE 64 si queremos reducir el alfa
		//alfabeto resultante. Puede ser util si queremos guardar la información
		//o enviar la información.
		String mensajeHashBase64 = Base64.getEncoder().encodeToString(resumen);
		System.out.println("Resumen hash BASE 64: " + mensajeHashBase64);
	}
}