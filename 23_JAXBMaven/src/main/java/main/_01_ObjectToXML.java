package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import beans.Direccion;
import beans.Persona;

public class _01_ObjectToXML {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			/*
			 * Obtiene el contexto asociado a la clase Persona, con dicho
			 * contexto podremos convertir el objeto a un xml y a la inversa. 
			 * Provoca una excepción de tipo JAXBException si la clase Persona 
			 * no cumple los requisitos para la conversión a XML, es decir, 
			 * contener las anotaciones necesarias y no cuenta con un constructor 
			 * sin argumentos.
			 */
			contexto = JAXBContext.newInstance(Persona.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}

		Marshaller m;
		try {
			/*
			 * Obtiene el objeto Marshaller asociado al contexto.
			 * Con dicho objeto podremos convertir un objeto en xml
			 * es decir, lo serializaremos
			 */
			m = contexto.createMarshaller();
			/*
			 * Establecer la propiedad JAXB_FORMATTED_OUTPUT con el valor true 
			 * permite que en la conversión a formato XML se incluyan retornos 
			 * de carro e indentación (sangrado del texto). 
			 * Prueba a ejecutar el programa con los valores true y 
			 * false para ver la diferencia.
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creamos el objeto Persona y su Direccion
			Persona p = new Persona(1, "Homer", "Simpson", 37);
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Gran Via");
			direccion.setTipoVia("Calle");
			direccion.setCp("28054");
			p.setDireccion(direccion);
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(p, System.out);
			//También podemos crear un fichero
			m.marshal(p, new File("homer.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
