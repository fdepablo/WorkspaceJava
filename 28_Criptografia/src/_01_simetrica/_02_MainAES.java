package _01_simetrica;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/*
 *  El mensaje a cifrar también se divide en bloques, pero esta vez cada bloque puede 
 *  ser de longitud variable, entre 128, 192 o 256 bits.

    1- La clave también puede ser de 128, 192 o 256 bits.

    2- Se trata de un algoritmo más rápido y seguro que el algoritmo DES.

    3- En Java se implementa de la misma manera que vimos en el apartado anterior,
    solo hay que modificar las siguientes líneas:
    generador = KeyGenerator.getInstance("AES");
    descifrador = Cipher.getInstance("AES");
 */
public class _02_MainAES {
	public static void main (String args[]) {
		System.out.println("Probando sistema de encriptación con algoritmo DES");
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			SecretKey paloEspartano = generador.generateKey();
			System.out.println("Paso 2: Se ha obtenido la clave");

			Cipher descifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			descifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el descifrador");
			
			String mensajeOriginal = "La cripta mágica";
			byte[] bytesMensajeOriginal = mensajeOriginal.getBytes();
			byte[] bytesMensajeCifrado = descifrador.doFinal(bytesMensajeOriginal);//cifrar el mensaje original
			String mensajeCifrado = new String(bytesMensajeCifrado);
			System.out.println("Mensaje Original: " + mensajeOriginal);
			System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			
			System.out.println("Desciframos el mensaje cifrado para comprobar que comprueba con el original");
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			byte[] bytesMensajeDescifrado = descifrador.doFinal(bytesMensajeCifrado);
			System.out.println("Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
			
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}
}
