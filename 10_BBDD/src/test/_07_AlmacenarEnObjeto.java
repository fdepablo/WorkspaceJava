package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidad.Persona;

public class _07_AlmacenarEnObjeto {
	public static void main(String[] args) {
		// Paso 1: Cargar el driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("No se ha encontrado el driver para MySQL");
					return;
				}
				System.out.println("Se ha cargado el Driver de MySQL");
				
				// Paso 2: Establecer conexión con la base de datos
				String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
				String user = "root";
				String pass = "";
				Connection con;
				try {
					con = DriverManager.getConnection(cadenaConexion, user, pass);
				} catch (SQLException e) {
					System.out.println("No se ha podido establecer la conexión con la BD");
					System.out.println(e.getMessage());
					return;
				}
				System.out.println("Se ha establecido la conexión con la Base de datos");
				
				// Paso 3: Interactuar con la BD 
				try {
					PreparedStatement sentencia = con.prepareStatement("SELECT * FROM PERSONAS WHERE ID=?");
					sentencia.setInt(1, 1);
					ResultSet rs = sentencia.executeQuery();
					Persona p = new Persona();
					while (rs.next()) {
						p.setId(rs.getInt("ID"));
						p.setNombre(rs.getString("NOMBRE"));
						p.setEdad(rs.getInt("EDAD"));
						p.setPeso(rs.getDouble("PESO"));
					}
					
					System.out.println(p);
				} catch (SQLException e) {
					System.out.println("Error al realizar el listado de productos");
					System.out.println(e.getMessage());
				}		
				
				// Paso 4: Cerrar la conexión
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("No se ha podido cerrar la conexión con la BD");
					System.out.println(e.getMessage());
					return;
				}
				System.out.println("Se ha cerrado la base de datos");
	}
}
