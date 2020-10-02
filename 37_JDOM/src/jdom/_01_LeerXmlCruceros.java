package jdom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/*
 * JDOM son librerias java que estan incluidas en la jdk, y nos sirven`
 * para trabajar con el arbol DOM. Todo documento xml se suele
 * transforman en los navegadores en nodos. Cada etiqueta se transforma
 * en un nodo elemento, los textos en un nodo texto y los atributos
 * se transforman en un noto atributo :O
 * https://www.w3schools.com/js/js_htmldom.asp
 */
public class _01_LeerXmlCruceros {
	public static void main(String[] args) {
		//lo primero necestimos una factoria que nos cree los objetos
		//el patron factoria es patron de diseño creacional, en la cual
		//su funcion es evitar el acoplamiento de clases y centralizar
		//la creacion de los objetos en una unica clase
		//Hay un concepto que se llama IoC, o inversion de control, que se
		//basa en que otra clase haga el new por ti.
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		//sigue el patron de diseño builder y cuya funcion es crear objetos
		//complejos de manera simple
		DocumentBuilder analizador;
		//el nodo documento
		Document doc;
		//Este nodo representara el nodo raiz
		Node raiz;
		
		try {
			analizador = fabrica.newDocumentBuilder();
			//lo primero es parsear el cruzros.xml para
			//convertilo en un arbol DOM, basicamente lo que hacen los navegadores
			//el arbol DOM seran objetos
			doc = analizador.parse("cruceros.xml");
			//ponemos la referencia raiz en el objeto Document
			raiz = doc.getDocumentElement();
			//le decimos que nos pinte todos los nodos texto del document
			System.out.println(raiz.getTextContent());
			System.out.println("-------------------------");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}