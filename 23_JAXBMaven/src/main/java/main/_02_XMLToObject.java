package main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import beans.Persona;

public class _02_XMLToObject {
	public static void main(String[] args) {
		try {
			JAXBContext contexto = JAXBContext.newInstance(Persona.class);
			//Esta vez creamos un objeto que nos permite pasar
			//de XML a Object, es decir deserializar
			//Lo leeremos a partir del fichero "homer.xml", donde se
			//serializo previamente el objeto.
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("homer.xml");
			if (fichero.exists()) {
				Object o = u.unmarshal(fichero);
				Persona p = (Persona) o;
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
