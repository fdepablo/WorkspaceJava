package _03_hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Resumen {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		byte[] cancion1 = "Bohemian Rhapsody".getBytes();
		byte[] cancion2 = "Imagine".getBytes();
		byte[] cancion3 = "We Are the Champions".getBytes();
		byte[] cancion4 = "Hotel California".getBytes();
		byte[] cancion5 = "Yesterday".getBytes();
		
		/*
		 * Creamos un objeto MessageDigest a través del método estático 
		 * getInstance() al que se le pasa el tipo de algoritmo que vamos a 
		 * utilizar. En este caso, el algoritmo MD5. Luego, actualizamos 
		 * nuestro objeto con todos los mensajes que queremos unir para 
		 * crear el resumen hash.
		 */
		//MessageDigest md = MessageDigest.getInstance("SHA-512");
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(cancion1);
		md.update(cancion2);
		md.update(cancion3);
		md.update(cancion4);
		md.update(cancion5);
		
		//El último paso será ejecutar el método digest() de nuestro 
		//objeto MessageDigest para obtener el resumen, que también 
		//será una cadena de bytes.
		
		byte[] resumen = md.digest();
		System.out.println("Resumen hash: " + new String(resumen));
	}
}