package _01_simetrica;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class _02_MainAES {
	public static void main (String args[]) {
		System.out.println("Probando sistema de encriptación con algoritmo AES");
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Generamos la clave simetrica. (Una escítala espartana)
			SecretKey paloEspartano = generador.generateKey();
			//Si se hiciera otra vez, obtendria otra clave DIFERENTE, por ejemplo
			//otro palo espartano con otras medidas
			System.out.println("Paso 2: Se ha obtenido la clave");
			
			//Objeto que nos permitira encriptar o desencriptar a partir de una
			//clave (o palo espartano)
			Cipher cifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el cifrador/descifrador");
			
			//Ahora el cifrador lo configuramos para que use la clave simetrica
			//para encriptar
			cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el cifrador");
						
			String mensajeOriginal = "Un gran poder implica una gran responsabilidad";
			//El cifrador trabaja con bytes, lo convertimos
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			System.out.println("Paso 5.1: Ciframos el mensaje original");
			//El cifrador devuelve una cadena de bytes
			byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Paso 5.2: Mensaje Original: " + mensajeOriginal);
			System.out.println("Paso 5.3: Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("Paso 6.1: Desciframos el criptograma:");
			//Ahora configuramos un descifrador para que use la clave simetrica
			//para desencriptar. Debemos de usar la MISMA clave para descifrar, NO
			//PODEMOS usar/generar una diferente.
			Cipher descifrador = Cipher.getInstance("AES");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
				
		//Simplificamos las excepciones capturando GeneralSecurityException
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}
}
