package juego.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import juego.entidades.Partida;

public class DaoGame {
	
	private Connection conexion;
	
	public static final String URL = "jdbc:derby:bbdd;create=true";

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
	
	public boolean guardar(Partida partida){
		if(!abrirConexion()){
			return false;
		}
		boolean alta = true;
		
		String query = "insert into partidas (nombre_jugador,puntuacion,velocidad) "
				+ " values(?,?)";
		try {
			//preparamos la query con valores parametrizables(?)
			PreparedStatement ps = conexion.prepareStatement(query);
			ps.setString(1, partida.getNombreJugador());
			ps.setInt(2, partida.getPuntuacion());
			ps.setInt(3, partida.getVelocidad());
			
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
	
	public List<Partida> listar(){
		if(!abrirConexion()){
			return null;
		}		
		List<Partida> listaGames = new ArrayList<>();
		
		String query = "select nombre_jugador,puntuacion,velocidad from partidas";
		try {
			PreparedStatement ps = conexion.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Partida game = new Partida();
				game.setNombreJugador(rs.getString(1));
				game.setPuntuacion(rs.getInt(2));
				game.setVelocidad(rs.getInt(3));
				
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
