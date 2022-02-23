
package jdom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class _03_LeerEscalas {
	public static void main(String[] args) {
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			doc = analizador.parse("cruceros.xml");
			raiz = doc.getDocumentElement();
			recorrerNodos(raiz);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private static void recorrerNodos(Node raiz) {
		NodeList nodos = raiz.getChildNodes();
		for (int i=0; i<nodos.getLength();i++) {
			// Iteraci�n por los elementos crucero.
			Node nodoHijo = nodos.item(i);
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				Node destino = nodoHijo.getChildNodes().item(1);
				System.out.println("Destino: " + destino.getTextContent());
				System.out.println("---------------------------------------------------");
				Node detalles = nodoHijo.getChildNodes().item(3);
				System.out.println("  Detalles: " + detalles.getTextContent());
				Node escalas = nodoHijo.getChildNodes().item(5);
				recorrerEscalas(escalas);
			}	
		}
	}
	
	private static void recorrerEscalas(Node escalas) {
		NodeList nodos = escalas.getChildNodes();
		System.out.println("  Escalas:");
		for (int i=0; i<nodos.getLength();i++) {
			Node escala = nodos.item(i);
			if (escala.getNodeType() == Node.ELEMENT_NODE) {
				//dame los atriburos del nodo escala, y quiero el atributo 0, es decir
				//el prierm atributo, a continuacion de pido el valor de ese nodo atributo
				String dia = escala.getAttributes().item(0).getNodeValue();
				Node parada = escala.getChildNodes().item(1);
				Node llegada = escala.getChildNodes().item(3);
				Node salida = escala.getChildNodes().item(5);
				System.out.print("                        ");
				System.out.print("Día " + dia + ": ");
				System.out.print(parada.getTextContent() + " ");
				System.out.print(llegada.getTextContent() + " - ");
				System.out.println(salida.getTextContent());
			}
		}
		System.out.println();
	}
}