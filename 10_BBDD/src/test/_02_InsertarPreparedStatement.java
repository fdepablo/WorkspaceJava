package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//IMPORTANTE
//EN TODAS LAS CONEXIONES A BBDD DEBEMOS DE USAR LA CLASE PREPARED STATEMENT EN LUGAR
//DE LA CLASE STATEMENT
public class _02_InsertarPreparedStatement {

	public static void main(String[] args) {
		// Paso 1: Establecemos los parametros de conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = "";
		
		// Paso 2: Interactuar con la BD 
		try (Connection con = DriverManager.getConnection(cadenaConexion, user, pass)){
			//esta es la manera que hay que hacer si quereis aprobar
			//porque? De momento ganamos en claridad, es mas visual
			String sql = "INSERT INTO PERSONAS (NOMBRE, EDAD, PESO) VALUES (?, ?, ?)"; 
			// en vez de poner los valores ponemos interrogantes
			
			String nombre = "Ernion Güeslei";
			int edad = 18;
			double peso = 46;
			
			System.out.println("Se va a ejecutar la siguiente sentencia SQL:");
			System.out.println(sql);
			
			//Notese que usamos PreparedStatement en vez de Statement
			PreparedStatement sentencia;
			sentencia = con.prepareStatement(sql);
			//por un lado mandamos la sql, y por otro mandamos los parametros
			//que la bbdd tiene que sustituir por las "?"
			sentencia.setString(1, nombre);//decimos que la primera "?" que se encuentre le ponga el nombre
			sentencia.setInt(2, edad);//
			sentencia.setDouble(3, peso);
			
			//Ejecutamos la query
			int afectados = sentencia.executeUpdate();
			System.out.println("Sentencia SQL ejecutada con éxito");
			System.out.println("Registros afectados: "+afectados);
		} catch (SQLException e) {
			System.out.println("Error al añadir una nueva persona");
			System.out.println(e.getMessage());
		}
	}

}