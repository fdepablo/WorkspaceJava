package _06_ficheros_array_objetos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EscrituraPersonas {

	public static final String nombreFichero = "personas.dat";
	
	public static void main(String[] args) {
		System.out.println("Vamos a salvar personas");
		List<Persona> listaPersona = new ArrayList<Persona>();
		Persona persona1 = new Persona();
		
		persona1.setDni("52887766s");
		persona1.setEdad(25);
		persona1.setPeso(78.2);
		
		persona1 = new Persona();
		
		persona1.setDni("adsfhkdsajhfds");
		persona1.setEdad(34);
		persona1.setPeso(34.2);
		
		listaPersona.add(persona1);
		
		File file = new File(nombreFichero);
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
			oos.writeObject(listaPersona);
			System.out.println("Objeto introducido");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		System.out.println("Cerrando programa");
	}

}
