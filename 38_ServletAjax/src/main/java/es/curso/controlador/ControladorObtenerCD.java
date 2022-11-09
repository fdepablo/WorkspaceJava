package es.curso.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.curso.modelo.entidad.CompactDisc;
import es.curso.modelo.persistencia.DaoCD;

/**
 * Servlet implementation class ControladorCD
 */
@WebServlet("/ControladorObtenerCD")
public class ControladorObtenerCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoCD daoCD = null;
	private int contador = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ControladorObtenerCD -> Procesando petición "
				+ "del cliente numero: " + contador++);
		
		daoCD = new DaoCD();
		List<CompactDisc> listaCD = daoCD.listar();
		
		//Con las librerías GSON podemos convertir objetos en Java 
		//a cadenas JSON facilmente, siempre y cuando tengan la misma estructura
		Gson gson = new Gson();
		String lista = gson.toJson(listaCD);
		System.out.println("ControladorObtenerCD -> lista en json: " + lista);
		
		//Establecemos el estado en la respuesta HTTP
		//sera leida por el objeto XMLHttpRequest en el lado del cliente
		response.setStatus(200);
		//Establecemos el MIME TYPE a json. El MIME TYPE es una convencion de la w3c
		//para establecer el tipo de archivo que se va a mandar entre los clientes
		//y los servidores
		response.setContentType("application/json");
		//Agregamos al body de la respuesta HTTP la lista en formato JSON
		response.getWriter().append(lista);
	}

}
