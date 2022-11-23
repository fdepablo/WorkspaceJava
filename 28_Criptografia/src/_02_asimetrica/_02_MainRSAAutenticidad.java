package _02_asimetrica;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class _02_MainRSAAutenticidad {
	public static void main(String[] args) {
		try {
			//En vez de KeyGenerator usamos KeyPairGenerator
			KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Obtenemos el par de claves (publica y privada)
			KeyPair claves = generador.generateKeyPair();
			PrivateKey clavePrivada = claves.getPrivate();
			PublicKey clavePublica = claves.getPublic();
			System.out.println("Paso 2: Se ha obtenido el par de claves");
			
			Cipher cifrador = Cipher.getInstance("RSA");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			cifrador.init(Cipher.ENCRYPT_MODE,clavePrivada);
			System.out.println("Paso 4.1: Hemos configurado el cifrador para usar clave privada");
			System.out.println("Paso 4.2: Cifrando de esta manera garantizamos AUTENTICIDAD");
			
			String mensajeOriginal = "Un gran poder implica una gran responsabilidad";
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			//ciframos el mensaje
			byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Paso 5.1: Hemos cifrado el mensaje original");
			System.out.println("Paso 5.2: Mensaje Original: " + mensajeOriginal);
			System.out.println("Paso 5.3: Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("Paso 6.1: Ahora vamos a descifrar el criptograma usando la clave publica");
			Cipher descifrador = Cipher.getInstance("RSA");
			descifrador.init(Cipher.DECRYPT_MODE, clavePublica);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
			
		} catch (GeneralSecurityException e) {
			System.out.println("Error al cifrar o descifrar el mensaje");
			System.out.println("Excepci�n de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
