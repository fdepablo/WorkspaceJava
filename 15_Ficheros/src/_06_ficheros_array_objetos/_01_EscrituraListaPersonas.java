package _06_ficheros_array_objetos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class _01_EscrituraListaPersonas {

	public static final String nombreFichero = "personas.dat";
	
	public static void main(String[] args) {
		System.out.println("Vamos a salvar personas");
		List<Persona> listaPersona = new ArrayList<Persona>();
		Persona persona = new Persona();		
		persona.setDni("52887766s");
		persona.setEdad(25);
		persona.setPeso(78.2);
		
		listaPersona.add(persona);
		
		persona = new Persona();		
		persona.setDni("52887768d");
		persona.setEdad(34);
		persona.setPeso(34.2);
		
		listaPersona.add(persona);
		
		File file = new File(nombreFichero);
	
		try (FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
			oos.writeObject(listaPersona);
			System.out.println("Objeto introducido");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println("Cerrando programa");
	}

}
