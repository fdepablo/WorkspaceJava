package conexion;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexionBBDD {

	private static String url,user,pwd;
	private static Connection conn;
	private static ConexionBBDD instance;

	static {
		url = "jdbc:mysql://localhost:3306/bbdd";
		user = "root";
		pwd = null;
	}

	private ConexionBBDD() { 
		super();
	}

	public static ConexionBBDD getInstance() {
		if (instance==null) {
			instance = new ConexionBBDD();
		}
		return instance;
	}
	
	public Connection getConnection() {
		conn = null;
		try {
			conn=DriverManager.getConnection(url, user, pwd);
			System.out.println("CONEXION CORRECTA");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("****NO CONECTADO****");
		}
		return conn;
	}
	
	

}