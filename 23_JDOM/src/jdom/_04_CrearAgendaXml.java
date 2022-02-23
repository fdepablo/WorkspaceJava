package jdom;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

//Aqui hacemos el proceso inverso, a partir de informacion, crear el xml
public class _04_CrearAgendaXml {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			// Creamos nuevo documento vacio
			doc = analizador.newDocument();
			// Añadimos elemento raiz
			Element agenda = doc.createElement("agenda");
			doc.appendChild(agenda);
			// A�adimos tres contactos al elemento raíz agenda.
			agregarContactos(agenda, doc);
			// Guardamos en disco el nuevo documento XML.
			guardar(doc);
			
			System.out.println("El archivo se ha creado con éxito");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void agregarContactos(Element agenda, Document doc) {
		// Agregamos primer contacto
		Element contacto = doc.createElement("contacto");
		agenda.appendChild(contacto);		
		Element nombre = doc.createElement("nombre");
		Text textoTony = doc.createTextNode("Tony Stark");
		nombre.appendChild(textoTony);
		contacto.appendChild(nombre);
		
		Element telefono = doc.createElement("telefono");
		//lo hacemos de manera directa
		telefono.appendChild(doc.createTextNode("612333333"));
		contacto.appendChild(telefono);

		// Agregamos segundo contacto
		contacto = doc.createElement("contacto");
		agenda.appendChild(contacto);		
		nombre = doc.createElement("nombre");
		nombre.appendChild(doc.createTextNode("PEDRO BOTIJO MONTERA"));
		contacto.appendChild(nombre);
		telefono = doc.createElement("telefono");
		telefono.appendChild(doc.createTextNode("622333444"));
		contacto.appendChild(telefono);
		
		// Agregamos tercer contacto
		contacto = doc.createElement("contacto");
		agenda.appendChild(contacto);		
		nombre = doc.createElement("nombre");
		nombre.appendChild(doc.createTextNode("MIGUEL MALATESTA SENTADO"));
		contacto.appendChild(nombre);
		telefono = doc.createElement("telefono");
		telefono.appendChild(doc.createTextNode("655444333"));
		contacto.appendChild(telefono);		
	}
	
	private static void guardar(Document doc) throws TransformerException {
		//fabrica de Transformes
		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		//creamos el objeto Transfomer, que nos permitira serializar el arbol
		//dom a un fichero
		Transformer conversor = fabricaConversor.newTransformer();
		//creamos la fuente de la cual sacaremos el arbol dom
		DOMSource fuente = new DOMSource(doc); 
		//Creamos el flujo de salida, al fichero que queremos (tubito)
		StreamResult resultado = new StreamResult(new File("agenda.xml"));
		//por ultimo, serializamos los datos
		conversor.transform(fuente, resultado);
	}
}