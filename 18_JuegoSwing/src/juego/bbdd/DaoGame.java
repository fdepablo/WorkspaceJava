package juego.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.Game;

public class DaoGame {
	
	private Connection conexion;
	
	public static final String URL = "jdbc:derby:game;create=true";

	public boolean abrirConexion(){
		try {
			conexion = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean guardar(Game partida){
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into games (NAME,SCORE) "
				+ " values(?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, partida.getNombre());
			ps.setInt(2, partida.getSpeed());
			
			int numeroFilasAfectadas = ps.executeUpdate();
			if(numeroFilasAfectadas == 0)
				alta = false;
			else
				alta = true;
		} catch (SQLException e) {
			System.out.println("alta -> Error al insertar: " + partida);
			alta = false;
			e.printStackTrace();
		} finally{
			cerrarConexion();
		}
		
		return alta;
	}
	
	public List<Game> listar(){
		if(!abrirConexion()){
			return null;
		}		
		List<Game> listaGames = new ArrayList<>();
		
		String query = "select NAME,SCORE from games";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Game game = new Game();
				game.setName(rs.getString(1));
				game.setSpeed(rs.getInt(2));
				
				listaGames.add(game);
			}
		} catch (SQLException e) {
			System.out.println("listar -> error al obtener los juegos");
			e.printStackTrace();
		} finally {
			cerrarConexion();
		}
		
		
		return listaGames;
	}
}
