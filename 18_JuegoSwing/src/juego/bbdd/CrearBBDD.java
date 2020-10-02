package juego.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CrearBBDD {
	
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection(DaoGame.URL);
			 
			String query = "CREATE TABLE games"
					+ "(id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
					+ "name VARCHAR(45),"
					+ "score INTEGER,"
					+ "CONSTRAINT primary_key PRIMARY KEY (id))";
			
			con.createStatement().execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
