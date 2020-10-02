package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Direccion;
import beans.GrupoPersonas;
import beans.Persona;

public class GrupoPersonasToXML {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(GrupoPersonas.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			return;
		}

		Marshaller m;
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			GrupoPersonas grupo = new GrupoPersonas();
			grupo.getPersonas().add(new Persona(1, "Homer", "Simpson", 48));
			grupo.getPersonas().add(new Persona(2, "Lisa", "Simpson", 12));
			grupo.getPersonas().add(new Persona(3, "Bart", "Simpson", 13));
			grupo.getPersonas().add(new Persona(4, "Marge", "Simpson", 40));
			
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Gran Via");
			direccion.setTipoVia("Calle");
			direccion.setCp("28054");
			grupo.getPersonas().get(0).setDireccion(direccion);

			m.marshal(grupo, new File("Simpson.xml"));
			System.out.println("El archivo Simpson.xml ha sido creado con éxito");
		} catch (JAXBException e) {
			System.out.println("Error convertiendo el objeto a formato XML");
			System.out.println(e.getMessage());
		}
	}
}
