package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import entidad.Direccion;
import entidad.Persona;

public class _01_ObjectToXML {
	public static void main(String[] args) {

		JAXBContext contexto;
		try {
			/*
			 *  Una vez anotadas las clases correctamente podemos proceder a
			 * trabajar con ellas para serializar o deserializar.
			 * 
			 *  En este ejemplo vamos a serializar un objeto a XML
			 * 
			 *  Primero debemos obtener el contexto asociado a la clase Persona, 
			 * con dicho contexto podremos convertir el objeto a un xml y a la inversa. 
			 * 
			 *  Ojo, provoca una excepción de tipo JAXBException si la clase 
			 * no cumple los requisitos para la conversión a XML, es decir, 
			 * contener las anotaciones necesarias y tener estructura JavaBean
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
			 *  El siguiente paso es obtener el objeto que es capaz
			 * de serializar otros objetos. Dicho objeto es de tipo
			 * "Marshaller" y se obtiene a partir del contexto
			 * creado en el paso anterior.
			 */
			m = contexto.createMarshaller();
			/*
			 *  Establecemos la propiedad JAXB_FORMATTED_OUTPUT con el valor true.
			 *  Permite que en la conversión a formato XML se incluyan retornos 
			 * de carro e indentación (sangrado del texto). 
			 *  Prueba a ejecutar el programa con los valores true y 
			 * false para ver la diferencia.
			 */
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			//Creamos el objeto Persona y su Direccion
			Persona p = new Persona(1, "Homer", "Simpson", 37);
			Direccion direccion = new Direccion();
			direccion.setNombreVia("Evergreen Terrace 742");
			direccion.setTipoVia("Calle");
			direccion.setCp("08056");
			p.setDireccion(direccion);
			
			//Convertimos un objeto a xml y lo imprimimos por pantalla
			m.marshal(p, System.out);
			//También podemos crear un fichero ".xml"
			m.marshal(p, new File("homer.xml"));
		} catch (JAXBException e) {
			System.out.println("Error convirtiendo el objeto a formato XML");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
