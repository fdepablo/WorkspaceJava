package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Direccion;
import entidad.Familia;
import entidad.Persona;

public class _03_FamiliaToXML {
	public static void main(String[] args) {

		/*
		 *  En este ejemplo vamos a ver como podemos trabajar con objetos
		 *  mas conplejos. Concretamente trabajaremos con objetos Familia,
		 *  Persona y Direccion.
		 */
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Familia.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;//Dejamos de ejecutar el metodo main
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
			familia.getPersonas().add(new Persona(5, "Magie", "Simpson", 3));
			
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Evergreen Terrace 742");
			direccion.setTipoVia("Calle");
			direccion.setCp("08056");
			
			familia.getPersonas().get(0).setDireccion(direccion);
			familia.getPersonas().get(1).setDireccion(direccion);
			familia.getPersonas().get(2).setDireccion(direccion);
			familia.getPersonas().get(3).setDireccion(direccion);
			familia.getPersonas().get(4).setDireccion(direccion);

			m.marshal(familia, new File("simpson.xml"));
			System.out.println("El archivo Simpson.xml ha sido creado con exito,"
					+ " refresque su Eclipse :)");
			
			//Si quisieramos deserializar el XML a objeto, deberíamos usar la
			//clase "Unmarshaller"
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			e.printStackTrace();
		}
	}
}
