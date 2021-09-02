package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Obtener {

	public static void main(String[] args) {
		// Paso 1: Establecemos los parametros de conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			PreparedStatement sentencia = con.prepareStatement("SELECT * FROM PERSONAS WHERE ID=?");
			sentencia.setInt(1, 6);
			ResultSet rs = sentencia.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("ID"));
				System.out.print(" - "); 
				System.out.print(rs.getString("NOMBRE"));
				System.out.print(" - "); 
				System.out.print(rs.getInt("EDAD"));
				System.out.print(" - "); 
				System.out.print(rs.getDouble("PESO"));
				System.out.println(); // Retorno de carro
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar el listado de productos");
			System.out.println(e.getMessage());
		}		
		
	}

}