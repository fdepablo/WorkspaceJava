package servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;

/*
 * Un servlet es un objeto capaz de mapear peticiones http
 * Esta es la otra maeran de crear servlet, en vez de que tomcat lo de de alta mediante web.xml
 * Podemos darlo de alta por antoaciones @WebServlet
 * 
 * PAra entrar en este servlet, estara mapeado a la URL /ServletPrueba
 * http://localhost:8080/32_JPAMVCMavenWeb/ServletPrueba 
 */
@WebServlet("/ServletPrueba")
public class ServletPrueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//los parametros siempre llegan en formato cadena
		String id = request.getParameter("id");
		int iId = Integer.parseInt(id);
		
		EntityManagerFactory factoria = Persistence.createEntityManagerFactory("32_JPAMVCMavenWeb");
		EntityManager em = factoria.createEntityManager();
		
		Persona p = em.find(Persona.class, iId);
		System.out.println(p);
		
		System.out.println("Fin de obtener persona");
		response.getWriter().append("<h1>Bienvenidos a nuestro servlet</h1>").append(p.toString());
	}

	
	//POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
