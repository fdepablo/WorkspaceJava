package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _00_Conexion {

	public static void main(String[] args) {
		
		// Paso 1: Cargar el driver Solo hace falta hacerlo una vez en todo el programa
		// El driver será usado por jdbc para las conexiones, y dependera del fabricante
		// de la bbdd y de su version
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		
		System.out.println("Se ha cargado el Driver de MySQL");
		
		// Paso 2: Establecer conexión con la base de datos
		// En la cadena de conexion podemos encontrar los siguientes valores
		// jdbc, este es el protocolo de conexion
		// mysql, este es el subprotocolo y tiene con la bbdd
		// localhost, esta es la IP a la que nos queremos conectar
		// 3306, el puerto por el que nos vamos a contectar, por defecto mysql es el 3306
		// bbdd, es el esquema de la bbdd a al que nos queremos conectar
		String cadenaConexion = "jdbc:mysql://localhost:3306/bbdd";
		String user = "root";
		String pass = ""; // sustituye por la contraseña que especificaste durante la instalación de MySQL.
		Connection con = null;
		try {
			//DriverManager es una clase que gestiona las conexiones, y aqui le
			//pedimos una conexion
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexión con la BD");
			System.out.println(e.getMessage());
			return;
		}
		
		System.out.println("Se ha establecido la conexión con la Base de datos");
		
		// Paso 3: Interactuar con la BD (todavía pendiente)
		
		
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