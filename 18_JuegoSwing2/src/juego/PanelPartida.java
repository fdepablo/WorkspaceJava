package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import juego.entidades.Bola;
import juego.entidades.Partida;
import juego.entidades.Raqueta;

public class PanelPartida extends JPanel{
	private static final long serialVersionUID = 1L;

	Partida partida;
	Raqueta raqueta;
	Bola bola;	
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Raqueta getRaqueta() {
		return raqueta;
	}

	public void setRaqueta(Raqueta raqueta) {
		this.raqueta = raqueta;
		raqueta.setPanelPartida(this);
	}

	public Bola getBola() {
		return bola;
	}

	public void setBola(Bola bola) {
		this.bola = bola;
		bola.setPanelPartida(this);
	}

	public PanelPartida(){
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				raqueta.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				raqueta.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		bola.paint(g2d);
		raqueta.paint(g2d);
		

		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(partida.getVelocidad()), 10, 30);
	}
	

}
