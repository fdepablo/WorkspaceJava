package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import juego.bbdd.DaoGame;

//Ejemplo sacado de la web y adaptado
//http://edu4java.com/es/game/game1.html
public class Game extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private Ball ball;
	private Racquet racquet;
	private int speed = 1;
	private String nombre = "";

	public Game() {
		
		racquet = new Racquet(this);
		ball = new Ball(this);
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	public Ball getBall(){
		return ball;
	}
	
	public Racquet getRacquet(){
		return racquet;
	}
	
	private void moveBall() {
		ball.move();
		racquet.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		racquet.paint(g2d);
		

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getSpeed()), 10, 30);
	}
	
	public void gameOver() {
		//Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getSpeed(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		DaoGame daoGame = new DaoGame();
		boolean guardado = daoGame.guardar(this);
		if(guardado){
			System.out.println("Se ha guardado correctamente");
			
		}else{
			System.out.println("No se ha guardado");
		}
		List<Game> listaGames = daoGame.listar();
		System.out.println(listaGames);
		JOptionPane.showMessageDialog(this, "Los ultimos scores son:\n" + listaGames.toString(),"Scores", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(400, 500);
		frame.setVisible(true);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			game.moveBall();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "Game [speed=" + speed + " nombre=" + nombre + "]\n";
	}
	
	
}
