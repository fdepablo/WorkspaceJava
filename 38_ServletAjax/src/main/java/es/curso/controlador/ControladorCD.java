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
@WebServlet("/ControladorCD")
public class ControladorCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoCD daoCD = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		daoCD = new DaoCD();
		List<CompactDisc> listaCD = daoCD.listar();
		Gson gson = new Gson();
		String lista = gson.toJson(listaCD);
		response.setStatus(200);
		//Establecemos el MIME TYPE a json. El MIME TYPE es una convencion de la w3c
		//para establecer el tipo de archivo que se va a mandar entre los clientes
		//y los servidores
		response.setContentType("application/json");
		response.getWriter().append(lista);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
