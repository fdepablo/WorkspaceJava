package _03_Objetos;

import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
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
public class Main {
	public static void main (String args[]) {
		System.out.println("Probando sistema de encriptación con algoritmo AES");
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			SecretKey paloEspartano = generador.generateKey();
			System.out.println("Paso 2: Se ha obtenido la clave");

			Cipher descifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			descifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el descifrador");
			
			//Creamos el objeto que queremos encriptar
			Persona p1 = new Persona(1, "Bart", 12, 45.5);
			
			//Usamos este objeto para ayudarnos a cifrar el objeto entero
			//Persona debe de ser Serializable, OJO arroja IOException
			SealedObject so = new SealedObject(p1, descifrador);
			
			System.out.println("Persona original: " + p1);
			System.out.println("Persona Cifrada: " + so.toString());
			//Podriamos guardar esta persona cifrada en un fichero o en BBDD
			//si quisieramos
			
			//Configuramos para descifrar, OJO arroja IOException
			descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			Persona p2 = (Persona)so.getObject(descifrador);
			System.out.println("Persona descifrada: " + p2);
			
		} catch (Exception gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}
}
