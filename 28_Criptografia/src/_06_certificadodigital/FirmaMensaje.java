package _06_certificadodigital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

/*
 * Ahora queremos que el poseedor de la firma pueda dar un paso más, como, por ejemplo:

   Aprovechar la clave pública que le ha sido otorgada para cifrar mensajes utilizando 
   el algoritmo RSA, mensajes que después solo podrán ser descifrados por el poseedor 
   de la clave privada, es decir, por el creador de la firma.
   
   Esta mejora es la que convierte la firma digital en un CERTIFICADO digital. Además 
   de la verificación, abre una vía de comunicación cifrada con el emisor del 
   certificado.

   Para lograrlo, el objeto Signature debe utilizar el algotitmo SHA256withRSA en 
   lugar del DSA.
 */
public class FirmaMensaje {
	public static void main(String[] args) throws BadPaddingException, GeneralSecurityException, IOException {

		
		File fichero = new File("clavePrivada.obj");
		//En caso de que exista la clave privada generada previamente la usamos
		//para leer contenido
		if (fichero.exists()) {
			PrivateKey clavePrivada = leerClavePrivada();
			String texto = decifrarTexto(clavePrivada);
			System.out.println("Mensaje descifrado: " + texto);
		} else {
			crearCertificado();
		}
	}

	private static void crearCertificado() {
		System.out.println("VAMOS A CREAR EL CERTIFICADO");
		try {
			//Muy parecido a el ejemplo anterior (04)
			System.out.println("CREAMOS LA FIRMA DIGITAL");
			KeyPairGenerator generadorDeClaves = KeyPairGenerator.getInstance("RSA");
			KeyPair claves = generadorDeClaves.generateKeyPair();
			PrivateKey clavePrivada = claves.getPrivate();

			Signature firmadorVerificador = Signature.getInstance("SHA256withRSA");

			firmadorVerificador.initSign(clavePrivada);

			byte[] mensajeSecreto = "123456".getBytes();

			firmadorVerificador.update(mensajeSecreto);

			byte[] firmaDigital = firmadorVerificador.sign();
			System.out.println("Firma: " + new String(firmaDigital));

			MensajeFirmado mf = new MensajeFirmado(claves.getPublic(), firmaDigital);
			guardar(mf, clavePrivada);

		} catch (GeneralSecurityException e) {
			System.out.println("Error al crear la firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

	private static void guardar(MensajeFirmado mf, PrivateKey clavePrivada) {
		try {
			//Este fichero guarda la firma digital con la clave publica
			FileOutputStream fichero = new FileOutputStream("firmaDigital.obj");
			//Este fichero guarda la clave privada, que usaremos para leer
			//mensajes cifrados
			FileOutputStream ficheroClavePrivada = new FileOutputStream("clavePrivada.obj");
			ObjectOutputStream bufferFirma = new ObjectOutputStream(fichero);
			ObjectOutputStream bufferClavePri = new ObjectOutputStream(ficheroClavePrivada);
			//El mensaje firmado lleva la clave publica y la firmadigital
			bufferFirma.writeObject(mf);
			//Aqui guardamos la clave privada
			bufferClavePri.writeObject(clavePrivada);
			
			bufferFirma.close();
			bufferClavePri.close();
			fichero.close();
			ficheroClavePrivada.close();
			System.out.println("El fichero de firma digital se ha creado con éxito");
		} catch (IOException e) {
			System.out.println("Error al grabar fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}

	public static PrivateKey leerClavePrivada() {
		PrivateKey pk;
		try {
			FileInputStream fichero = new FileInputStream("clavePrivada.obj");
			ObjectInputStream buffer = new ObjectInputStream(fichero);
			pk = (PrivateKey) buffer.readObject();
			buffer.close();
			fichero.close();
			return pk;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static String decifrarTexto(PrivateKey clavePrivada) {
		try {
			File ficheroCifrado = new File("mensaje.obj");
			if (ficheroCifrado.exists()) {
				Cipher descifrador = Cipher.getInstance("RSA");
				descifrador.init(Cipher.DECRYPT_MODE, clavePrivada);

				FileInputStream fichero = new FileInputStream("mensaje.obj");
				ObjectInputStream buffer = new ObjectInputStream(fichero);
				byte[] mensajeCifrado = (byte[]) buffer.readObject();
				buffer.close();
				fichero.close();

				byte[] bytesMensajeDescifrado = descifrador.doFinal(mensajeCifrado);
				return new String(bytesMensajeDescifrado);
			} else {
				return "No hay mensaje que descifrar";
			}
		} catch (GeneralSecurityException | IOException | ClassNotFoundException e) {
			System.out.println("Error al descifrar el mensaje");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return null;
		}
	}
}
