package jdom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class _02_LeerCruceros {
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
		//este metodo nos devuelve todos los nodos hijos Directos del elemento raiz "cruceros"
		NodeList nodos = raiz.getChildNodes();
		//aunque solo haya 2 nodos "crucero" nos pinta 5 LOL!
		//porque? porque los saltos de linea que hay entre las etiquetas se cuentan
		//como nodos texto :) :) :)
		System.out.println("Elementos en el nodo raíz: " + nodos.getLength());
		//Aqui queremos pintar todos los elementos, pero evitando los nodos texto
		//que son nodos hijos directos de "cruceros"
		for (int i=0; i<nodos.getLength();i++) {//5
			// Iteración por los elementos crucero.
			Node nodoHijo = nodos.item(i);
			//Solo accedemos a los nodos elemento, evitamos los nodos texto
			//otra manera if(nodoHijo.item(i).getNodeName().equals("crucero"))
			//pero habria que conocer el nombre del nodo
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {
				//Accedemos al nodo 1 ya que el 0 es un texto (otra vez por el tema de los saltos de linea)
				//esto no se deberia hacer asi, si no que habria que 
				//volver a recorrer todos los nodos hijos, y solo pintar
				//los que sean nodo elemento
				Node destino = nodoHijo.getChildNodes().item(1);
				System.out.println("  Destino: " + destino.getTextContent());
				Node detalles = nodoHijo.getChildNodes().item(3);
				//Lo suyo sería recorrer los nodos hijos de los detalles para
				//sacar toda la información
				//detalles.getChildNodes();
				System.out.println("  Detalles: " + detalles.getTextContent());
			}	
		}
	}
}