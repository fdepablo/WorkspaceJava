package main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import entidad.Persona;

public class _02_XMLToObject {
	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Persona.class);
			// En este ejemplo vamos a hacer el paso inverso al anterior, es decir
			//esta vez creamos un objeto que nos permita deserializar el xml a objeto
			// Lo leeremos a partir del fichero "homer.xml", donde se
			//serializo previamente el objeto en el ejemplo anterior.
			
			// Para deserializar usaremos el objeto "Unmarshaller"
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("homer.xml");
			if (fichero.exists()) {
				Object o = u.unmarshal(fichero);
				Persona p = (Persona) o;
				// Una vez convertido a objeto ya podemos trabajar con él.
				System.out.println(p.getApellido());
				System.out.println(p.getNombre());
				System.out.println(o);
			} else {
				System.out.println("Fichero XML Homer.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
	}
}
