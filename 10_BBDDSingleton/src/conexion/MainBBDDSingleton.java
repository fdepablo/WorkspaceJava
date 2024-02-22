package conexion;

import java.sql.Connection;

public class MainBBDDSingleton {

	public static void main(String[] args) {
		ConexionBBDD conBBDD = ConexionBBDD.getInstance();
		//Aplicamos try-with-resource para que se ejecute el método
		//"close()" de una conexión automáticamente
		try(Connection conn = conBBDD.getConnection();){
			if(conn != null) {
				System.out.println("Se ha establecido la conexión con la Base de datos");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
