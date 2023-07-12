package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Direccion;
import beans.Familia;
import beans.Persona;

public class FamiliaToXML {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Familia.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			return;
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Familia familia = new Familia();
			familia.setNombre("Los Simpsons");
			familia.setCiudad("Springfield");
			
			familia.getPersonas().add(new Persona(1, "Homer", "Simpson", 38));
			familia.getPersonas().add(new Persona(2, "Lisa", "Simpson", 8));
			familia.getPersonas().add(new Persona(3, "Bart", "Simpson", 11));
			familia.getPersonas().add(new Persona(4, "Marge", "Simpson", 35));
			
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Evergreen Terrace");
			direccion.setTipoVia("742");
			direccion.setCp("28054");
			familia.getPersonas().get(0).setDireccion(direccion);

			m.marshal(familia, new File("Simpson.xml"));
			System.out.println("El archivo Simpson.xml ha sido creado con éxito");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
		}
	}
}
