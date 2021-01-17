package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class _05_Modificar {

	public static void main(String[] args) {		
		// Paso 1: Establecemos los parametros de conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
			
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass);){
			
			String sql = "update personas set NOMBRE=?, EDAD=?, PESO=? WHERE ID=?";
			
			String nombre = "Dumbeldor";
			int edad = 600;
			double peso = 89.7;
			int id = 6;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			PreparedStatement sentencia = con.prepareStatement(sql);
			
			sentencia.setString(1, nombre);
			sentencia.setInt(2, edad);
			sentencia.setDouble(3, peso);
			sentencia.setInt(4, id);
			
			//como estamos cambiando datos de la BBDD, hacemos un executeUpdate
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir nuevo cliente");
			System.out.println(e.getMessage());
		}		
	}
}