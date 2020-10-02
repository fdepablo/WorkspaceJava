package basex;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.xqj.basex.BaseXXQDataSource;

public class _02_NodosProducto {
	public static void main(String[] args) {
		XQDataSource xds = new BaseXXQDataSource();
		XQConnection con;
		XQExpression expr;
		XQResultSequence result;
		String sentencia;

		try {
			xds.setProperty("serverName", "localhost");
			xds.setProperty("port", "1984");
			con = xds.getConnection("admin", "admin");
		} catch (XQException e) {
			System.out.println("Error al establecer la conexión con BaseX");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Establecida la conexión con BaseX");
		sentencia = "for $pro in fn:collection('almacen')//productos return $pro/producto";
		//NOTA, XQUERY tambien permite sentencias de CUD (create, update y delete)
		//en la carpeta "xq" hay ejemplos de como realizarlos
		try {
			expr = con.createExpression();
			result = expr.executeQuery(sentencia);
		} catch (XQException e) {
			System.out.println("Error al ejecutar la sentencia XQuery");
			System.out.println(e.getMessage());
			return;
		}
		
		int contador = 0;
		try {
			//Podemos recorrernos tambien el resultado como si de un arbol
			//DOM se tratara, es decir, acceder a sus nodos elemento o texto
			while (result.next()) {
				contador++;
				System.out.println("Producto nº " + contador);
				Node nodoProducto = result.getNode();
				//Esta funcion mostrara por pantalla el nodo
				mostrarProducto(nodoProducto);
			}
		} catch (XQException e) {
			System.out.println("Error al recorrer los elementos obtenidos");
			System.out.println(e.getMessage());
		}
		
		try {
			con.close();
		} catch (XQException e) {
			System.out.println("Error al cerrar la conexión con BaseX");
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Funcion que muestra por pantalla un nodo producto
	 * 
	 * @param nodo con el siguiente formato:
	 * <productos>
	 * 		<producto>
				<nombreProducto>Té Dharamsala</nombreProducto>
				<cantidadPorUnidad>10 cajas x 20 bolsas</cantidadPorUnidad>
				<precio>20.16</precio>
				<stock>39</stock>
			</producto>
		</productos>
	 */
	private static void mostrarProducto(Node nodo) {
		NodeList nodos = nodo.getChildNodes();//nos devuelve todos los nodo "producto"
		for (int i=0; i<nodos.getLength();i++) {//recorrenmos todos los nodos "producto"
			Node nodoHijo = nodos.item(i);//obtengo el nodo
			if (nodoHijo.getNodeType() == Node.ELEMENT_NODE) {//solo cogemos los nodos elemento
				System.out.println(nodoHijo.getNodeName() + ": " + nodoHijo.getTextContent());
			}
		}
	}
}