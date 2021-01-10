
package _06_ficheros_array_objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class _02_LecturaListaPersonas {

	public static void main(String[] args) {
		File file = new File(_01_EscrituraListaPersonas.nombreFichero);
		
		try (FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			List<Persona> listaPersona = (List<Persona>)ois.readObject();
			
			System.out.println("Objeto leido");
			System.out.println("Imprimiendo personas");
			
			for(Persona p : listaPersona){
				System.out.println(p);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Cerrando programa");
	}

}
