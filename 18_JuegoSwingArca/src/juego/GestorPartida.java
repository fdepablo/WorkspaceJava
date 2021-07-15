package juego;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import juego.entidades.Bola;
import juego.entidades.Partida;
import juego.entidades.Raqueta;

public class GestorPartida {

	private PanelPartida panelPartida;
	
	public void iniciar() throws Exception{
		JFrame frame = new JFrame("Mini Tennis");
		
		Partida partida = new Partida();
		partida.setVelocidad(1);
		partida.setNombreJugador("Felix");
		
		Bola bola = new Bola();
		bola.setDiameter(30);
		bola.setLocation(0,0);
		
		Raqueta raqueta = new Raqueta();
		raqueta.setSize(60,10);
		raqueta.setLocation(200, 330);
		
		panelPartida = new PanelPartida();
		panelPartida.setPartida(partida);
		panelPartida.setRaqueta(raqueta);
		panelPartida.setBola(bola);	
		
		frame.add(panelPartida);
		frame.setSize(400, 500);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			mover();
			panelPartida.repaint();
			Thread.sleep(10);
		}
	}
	
	public void gameOver() {
		//Sound.BACK.stop();
		Sound.GAMEOVER.play();
		panelPartida.getPartida().setPuntuacion(panelPartida.getPartida().getVelocidad());
		JOptionPane.showMessageDialog(panelPartida, "Tu puntuacion es: " + panelPartida.getPartida().getPuntuacion(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		/*
		DaoGame daoGame = new DaoGame();
		boolean guardado = daoGame.guardar(this);
		if(guardado){
			System.out.println("Se ha guardado correctamente");
			
		}else{
			System.out.println("No se ha guardado");
		}
		List<Partida> listaGames = daoGame.listar();
		System.out.println(listaGames);
		JOptionPane.showMessageDialog(this, "Los ultimos scores son:\n" + listaGames.toString(),"Scores", JOptionPane.YES_NO_OPTION);
		*/
		System.exit(JPanel.ABORT);
	}
	
	public void mover() {
		boolean tocoSuelo = panelPartida.getBola().mover();
		if(tocoSuelo){
			gameOver();
		}
		panelPartida.getRaqueta().mover();
	}
}
