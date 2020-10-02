package transacciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Cuando ejecutamos varias queries en un entorno de transaccionalidad 
//quiere decir que ejecutamos todas las queries como si fuera una
//es decir, si falla una deben de fallar todas
public class Principal {

	public static void main(String[] args) throws SQLException {
		
		// Paso 1: Cargar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		System.out.println("Se ha cargado el Driver de MySQL");
		
		// Paso 2: Establecer conexión con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/Ferreteria";
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
			//por defecto cada vez que lanzamos una consulta se hace commit a la bbdd
			//así pues lo desactivamos
			con.setAutoCommit(false);
			//Se debería hacer con preparedstatements
			Statement sentencia = con.createStatement();
			
			String sql = "INSERT INTO CLIENTE VALUES ('51666666A','ROCAFLOR DELGADO RODOLFO', 'C/ PITONISA, 45', '616656644', 'SEVILLA');";
			sentencia.executeUpdate(sql);
			sql = "INSERT INTO FACTURA VALUES (5446,'2018/04/23', 0, '51666666A');";
			sentencia.executeUpdate(sql);
			sql = "INSERT INTO DETALLE VALUES (5446,'MAR2', 1, 7);";
			sentencia.executeUpdate(sql);		
			sql = "INSERT INTO DETALLE VALUES (5446,'TOR7', 2, 0.8);";
			sentencia.executeUpdate(sql);	
			sql = "UPDATE PRODUCTO SET STOCK=STOCK-1 WHERE CODIGO='MAR2'";
			sentencia.executeUpdate(sql);	
			sql = "UPDATE PRODUCTO SET STOCK=STOCK-2 WHERE CODIGO='TOR7'";
			sentencia.executeUpdate(sql);	
			
			//si llegamos a este punto sin problema, persistimos todas las
			//queries lanzadas contra la bbdd
			con.commit();
			
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al añadir la factura");
			System.out.println(e.getMessage()); 
			//si en algun caso ha ocurrido algún error, eliminamos todas las
			//anteriores queries que se hayan lanzado
			con.rollback();
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