package juego.entidades;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import juego.PanelPartida;

public class Raqueta extends Rectangle{
	private static final long serialVersionUID = 1L;

	private int incremento_x = 0;
	private PanelPartida panelPartida;

	public Raqueta(){
		super();
	}

	public Raqueta(int x, int y, int width, int height) {
		this.setBounds(x, y, width, height);
	}

	public void mover() {
		if (x + incremento_x > 0 && 
				x + incremento_x < panelPartida.getWidth() - width)
			x = x + incremento_x;
		this.setBounds(x, y, width, height);
	}

	public void paint(Graphics2D g) {
		g.fill(this);
	}

	public void keyReleased(KeyEvent e) {
		incremento_x = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT ||
				e.getKeyCode() == KeyEvent.VK_A)
			incremento_x = -panelPartida.getPartida().getVelocidad();
		if (e.getKeyCode() == KeyEvent.VK_RIGHT ||
				e.getKeyCode() == KeyEvent.VK_D)
			incremento_x = panelPartida.getPartida().getVelocidad();
	}

	public int getTopY() {
		return y - height;
	}
	public PanelPartida getPanelPartida() {
		return panelPartida;
	}

	public void setPanelPartida(PanelPartida panelPartida) {
		this.panelPartida = panelPartida;
	}

}