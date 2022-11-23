package _01_simetrica;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class _01_MainDES {
	public static void main(String[] args) throws IOException {
		System.out.println("Probando sistema de encriptación con algoritmo DES");
		try {
			//Generador de claves simetricas (escítalas espartanas)
			KeyGenerator generador = KeyGenerator.getInstance("DES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			//Generamos la clave simetrica. (Una escítala espartana)
			SecretKey paloEspartano = generador.generateKey();
			//Si se hiciera otra vez, obtendria otra clave DIFERENTE, por ejemplo
			//otro palo espartano con otras medidas
			System.out.println("Paso 2: Se ha obtenido la clave");
			
			//Objeto que nos permitira encriptar o desencriptar a partir de una
			//clave (o palo espartano)
			Cipher cifrador = Cipher.getInstance("DES");
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
			Cipher descifrador = Cipher.getInstance("DES");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
	
			//Todas estas excepciones extienden de GeneralSecurityException
			//por lo que se puede simplificar simplemente capturando esa excepci�n
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			//NoSuchAlgorithmException: se produce cuando se especifica un algoritmo de cifrado 
			//que no existe.
			//NoSuchPaddingException: cuando la clave no tiene la configuraci�n correcta
			//InvalidKeyException: la clave es inv�lida (codificaci�n incorrecta, 
			//longitud incorrecta o no est� inicializada)
			System.out.println("Error al crear y configurar el descifrador");
			System.out.println(e.getMessage());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			//IllegalBlockSizeException: longitud incorrecta de alguno de los bloques de 
			//cifrado por un error durante el algoritmo.
			//BadPaddingException: cuando la clave no tiene la configuraci�n correcta
			System.out.println("Error al cifrar el mensaje");
			System.out.println(e.getMessage());
		}
	}
}
