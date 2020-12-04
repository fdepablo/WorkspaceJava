package _05_firmadigital;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

/*
 * 
   
   El resumen hash solo permite comprobar la integridad del mensaje 
   (si ha sufrido cambios), pero no permite verificar la identidad del organismo o 
   persona que envió dicho mensaje. 
   
   Aquí es donde entra en juego la firma digital:

   ** Firma digital = resumen hash + verificación de identidad **
   
   La firma digital puede cubrir los siguientes objetivos:

   1) Comprobar la integridad de los datos transmitidos mediante el resumen hash.
   2) Identificar el origen de dicho mensaje(quien lo escribio). 
   Si la firma contiene credenciales (usuario y clave), se puede utilizar para 
   verificar dichos credenciales.

   3) Garantía de no repudio, es decir, que el autor del mensaje no puede negar su autoría.
   
   Debemos implementar dos metodos distintos:
   
   1) Un método para la creación de la firma digital, que utilizará la clave privada.
   (Esta clase, FirmaMensaje.java). Ver FirmaDigital1.jpg

   2) Un método para la verificación de la firma digital, que utilizará la clave 
   pública asociada con la clave privada con la que se creó la firma.
   (La Clase AccesoConFirmaDigital.java). Ver FirmaDigital2.jpg
   
   
   DSA (Digital Signature Algorithm) es un algoritmo para firma digital que 
   permite asociar un mensaje con el emisor que lo ha transmitido, 
   certificando su autoría.
 */
public class FirmaMensaje {
	public static void main(String[] args) {
		
		System.out.println("VAMOS A CREAR UNA FIRMA DIGITAL");
		try {
			//Generamos el par de claves
			KeyPairGenerator generadorDeClaves = KeyPairGenerator.getInstance("DSA");
			//Aqui tenemos la clave privada y la clave publica
			KeyPair claves = generadorDeClaves.generateKeyPair();
			//Cogemos la clave publica que utilizaremos para encriptar el mensaje hash
			PrivateKey clavePrivada = claves.getPrivate();
			
			//Utilizamos el algoritmo SHA256withDSA, si se utiliza DSA a secas utiliza 
			//SHA de 128 y da un error
			Signature firmadorVerificador = Signature.getInstance("SHA256withDSA");
			
			//inicializamos la firma con la clave privada
			firmadorVerificador.initSign(clavePrivada);
			
			byte[] mensajeSecreto = "123456".getBytes();
			
			//introducimos el mensaje que queremos firmar
			firmadorVerificador.update(mensajeSecreto);
			
			//Creamos la firma digital, a partir del mensajeSecreto y la 
			//clave privada
			byte[] firmaDigital = firmadorVerificador.sign();
			
			System.out.println("Firma: " + new String(firmaDigital));
			
			MensajeFirmado mf = new MensajeFirmado(claves.getPublic(), firmaDigital);
			guardar(mf);
			
		} catch (GeneralSecurityException e) {
			System.out.println("Error al crear la firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void guardar(MensajeFirmado mf) {
		try {
			FileOutputStream fichero = new FileOutputStream("firmaDigital.obj");
			ObjectOutputStream buffer = new ObjectOutputStream(fichero);
			buffer.writeObject(mf);
			buffer.close();
			fichero.close();
			System.out.println("El fichero de firma digital se ha creado con éxito");
		} catch (IOException e) {
			System.out.println("Error al grabar fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}
