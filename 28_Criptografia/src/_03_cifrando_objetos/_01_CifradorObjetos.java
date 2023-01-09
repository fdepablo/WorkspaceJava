package _03_cifrando_objetos;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class _01_CifradorObjetos {
	public static void main (String args[]) {
		System.out.println("Probando sistema de encriptación con algoritmo AES");
		try {
			KeyGenerator generador = KeyGenerator.getInstance("AES");
			System.out.println("Paso 1: Se ha obtenido el generador de claves");
			
			SecretKey paloEspartano = generador.generateKey();
			System.out.println("Paso 2: Se ha obtenido la clave");

			Cipher cifrador = Cipher.getInstance("AES");
			System.out.println("Paso 3: Hemos obtenido el descifrador");
			
			cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
			System.out.println("Paso 4: Hemos configurado el descifrador");
			
			//Creamos el objeto que queremos encriptar
			Persona p1 = new Persona(1, "Bart", 12, 45.5);
			
			System.out.println("Paso 5.1. Ciframos la persona");
			//Usamos este objeto para ayudarnos a cifrar el objeto entero
			//Persona debe de ser Serializable, OJO arroja IOException
			SealedObject so = new SealedObject(p1, cifrador);
			
			System.out.println("Paso 5.2: Persona original: " + p1);
			System.out.println("Paso 5.3: Persona Cifrada: " + so);
			//Podriamos guardar esta persona cifrada en un fichero o en BBDD
			//si quisieramos
			
			//Configuramos para descifrar, OJO arroja IOException
			cifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			Persona p2 = (Persona)so.getObject(cifrador);
			System.out.println("Paso 6: Persona descifrada: " + p2);
			
		} catch (Exception gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
	}
}
