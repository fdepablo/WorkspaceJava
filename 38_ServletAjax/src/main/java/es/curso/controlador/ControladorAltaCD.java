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
		
		InputStream inputStream = request.getInputStream();	
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String json = bufferedReader.readLine();
		System.out.println("Cadena entrante: " + json);
		
		Gson gson = new Gson();
		CompactDisc cd = gson.fromJson(json, CompactDisc.class);
		DaoCD daoCD = new DaoCD();
		//Validaciones
		boolean insertado = daoCD.add(cd);
		response.getWriter().append(Boolean.toString(insertado));
	}
	
	

}
