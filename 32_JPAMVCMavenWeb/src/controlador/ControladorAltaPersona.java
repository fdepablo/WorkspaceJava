package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;
import modelo.negocio.GestorPersona;

/**
 * Servlet implementation class ControladorAltaPersona
 */
@WebServlet("/altaPersona")
public class ControladorAltaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	//como el formulario hace un metodo post, entramos por aqui
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String peso = request.getParameter("peso");
		
		int iEdad = Integer.parseInt(edad);
		int iPeso = Integer.parseInt(peso);
		
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setPeso(iPeso);
		p.setEdad(iEdad);
		
		//habria que comunicarse con la capa gestora dentro del modelo
		GestorPersona gp = new GestorPersona();
		int respuesta = gp.alta(p);
		
		//ya que siempre quiero mostrar la lista de personas
		//se la pedimos al gestor y se la pasamos a la vista (jsp)
		List<Persona> listaPersona = gp.listar();
		request.setAttribute("listaPersonas", listaPersona);
		
		switch (respuesta) {
		case -2:
			//Como queremos avisar a la pagina que no se ha podido dar de alta
			//le podemos mandar mensajes, podemos mandar lo que sea
			//es una estructura de tipo hash que podremos recuperar en la parte de 
			//la vista(jsps)
			request.setAttribute("mensajeError", "La edad ha sido menor que 18, no se ha dado de alta");
			
			//mediante requestDisptcher le decimos a donde queremos ir, es decir,
			//continuamos con la peticion http en otro recurso
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			break;
		case -1:
			//caso nombre menor de 3 caracteres
			request.setAttribute("mensajeError", "El nombre tiene que tener al menos 3 caracteres");
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			break;
		default:
			// en caso de que se haya dado de alta
			request.setAttribute("mensaje", "Persona dada de alta con ID: " + respuesta);
			request.getRequestDispatcher("principal.jsp").forward(request, response);
			break;
		}

	}

}
