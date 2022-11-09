package es.curso.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import es.curso.modelo.entidad.CompactDisc;
import es.curso.modelo.persistencia.DaoCD;



/**
 * Servlet implementation class ControladorAltaCD
 */
@WebServlet("/ControladorAltaCD")
public class ControladorAltaCD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Para leer el mensaje del body de la petición HTTP debemos de recurrir
		//a las siguientes clases
		InputStream inputStream = request.getInputStream();	
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(isr);
		
		String json = bufferedReader.readLine();
		System.out.println("ControladorAltaCD -> Cadena entrante: " + json);
		
		//Con las librerías GSON podemos convertir JSON a objetos
		//Java facilmente, siempre y cuando tengan la misma estructura
		Gson gson = new Gson();
		CompactDisc cd = gson.fromJson(json, CompactDisc.class);
			
		//Nos comunicamos con la capa DAO para "persistir" la información
		DaoCD daoCD = new DaoCD();
		boolean insertado = daoCD.add(cd);
		
		//Mandamos la respuesta al cliente
		response.setStatus(200);
		response.setContentType("text/plain");
		response.getWriter().append(Boolean.toString(insertado));
	}
	
	

}
