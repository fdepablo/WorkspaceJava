package _06_certificadodigital;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

import javax.crypto.Cipher;

public class AccesoConFirmaDigital {

public static void main(String[] args) {
		
		MensajeFirmado mf;
		try {
			FileInputStream fichero = new FileInputStream("firmaDigital.obj");
			ObjectInputStream buffer = new ObjectInputStream(fichero);
			mf = (MensajeFirmado) buffer.readObject();
			buffer.close();
			fichero.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer fichero de firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			return;
		}
		
		Scanner lector = new Scanner(System.in);
		
		try {
			Signature firmadorVerificador = Signature.getInstance("SHA256withRSA");
			firmadorVerificador.initVerify(mf.getClavePublica());
			
			System.out.println("¿Cuál es la clave secreta?");
			String mensajeSecreto = lector.nextLine();
			
			firmadorVerificador.update(mensajeSecreto.getBytes());
			
			boolean ok = firmadorVerificador.verify(mf.getFirma());
			if (ok) {
				System.out.println("Verificación OK, Bienvenido al sistema");
				crearMensajeCifrado(mf.getClavePublica(), lector);
			}
			else {
				System.out.println("La verificación ha fallado, Acceso denegado");
			}
			
			lector.close();
			
		} catch (GeneralSecurityException e) {
			System.out.println("Error en la verificación de la firma digital");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
			lector.close();
			return;
		}
	}

	private static void crearMensajeCifrado(PublicKey clavePublica, Scanner lector) {
		System.out.println("Escribe un mensaje: ");
		String mensaje = lector.nextLine();
		try {
			Cipher cifrador = Cipher.getInstance("RSA");
			cifrador.init(Cipher.ENCRYPT_MODE, clavePublica);
			byte[] bytesMensajeCifrado = cifrador.doFinal(mensaje.getBytes());

			FileOutputStream fichero = new FileOutputStream("mensaje.obj");
			ObjectOutputStream buffer = new ObjectOutputStream(fichero);
			buffer.writeObject(bytesMensajeCifrado);
			buffer.close();
			fichero.close();
			
			System.out.println("Mensaje cifrado: " + new String(bytesMensajeCifrado));

			System.out.println("El mensaje se ha grabado en el fichero mensaje.obj");
		} catch (GeneralSecurityException | IOException e) {
			System.out.println("Error al grabar el fichero mensaje.obj");
			System.out.println("Excepción de tipo: " + e.getClass().getName());
			System.out.println(e.getMessage());
		}
	}
}