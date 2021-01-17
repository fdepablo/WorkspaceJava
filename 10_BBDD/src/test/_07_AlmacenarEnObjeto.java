package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Persona;

public class _07_AlmacenarEnObjeto {
	public static void main(String[] args) {
		// Paso 1: Establecemos los parametros de conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";

		// Paso 2: Interactuar con la BD
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM PERSONAS");
			ResultSet rs = sentencia.executeQuery();
			
			List<Persona> listadoPersonas = new ArrayList<Persona>();
			while (rs.next()) {
				Persona p = new Persona();
				p.setId(rs.getInt("ID"));
				p.setNombre(rs.getString("NOMBRE"));
				p.setEdad(rs.getInt("EDAD"));
				p.setPeso(rs.getDouble("PESO"));
				
				listadoPersonas.add(p);
			}

			System.out.println(listadoPersonas);
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}
	}
}
