package juego.entidades;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import juego.PanelPartida;

public class Bola extends Ellipse2D.Double{
	private static final long serialVersionUID = 1L;
	
	//Hacia donde se mueve la bola
	//Sera el incremento que se mueve la bola
	//empieza en 1 pero será modificado por la velocidad
	//del juego
	private int incremento_x;
	private int incremento_y;
	private PanelPartida panelPartida;
	
	public PanelPartida getPanelPartida() {
		return panelPartida;
	}
	
	public void setLocation(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void setDiameter(double diametre){
		this.width = diametre;
		this.height = diametre;
	}

	public void setPanelPartida(PanelPartida panelPartida) {
		this.panelPartida = panelPartida;
		incremento_x = panelPartida.getPartida().getVelocidad();
		incremento_y = panelPartida.getPartida().getVelocidad();
	}

	public Bola() {
	}

	public boolean mover() {
		//boolean changeDirection = true;
		//Commprobamos si tocamoscualquier de los 4 laterales
		//del JPanel
		if (x + incremento_x < 0)
			incremento_x = panelPartida.getPartida().getVelocidad();
		else if (x + incremento_x > panelPartida.getWidth() - height)
			incremento_x = -panelPartida.getPartida().getVelocidad();
		else if (y + incremento_y < 0)
			incremento_y = panelPartida.getPartida().getVelocidad();
		else if (y + incremento_y > panelPartida.getHeight() - height)
			return true;
		else if (collision()){
			incremento_y = -panelPartida.getPartida().getVelocidad();
			y = panelPartida.getRaqueta().getTopY() - height;
			panelPartida.getPartida().setVelocidad(panelPartida.getPartida().getVelocidad()+1);;
		} //else 
			//changeDirection = false;
		
		//if (changeDirection) 
			//Sound.BALL.play();
		x = x + incremento_x;
		y = y + incremento_y;
		return false;
	}

	private boolean collision() {
		return panelPartida.getRaqueta().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fill(this);
	}

}