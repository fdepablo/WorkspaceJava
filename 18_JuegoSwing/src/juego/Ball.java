package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game = game;
	}

	void move() {
		//boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.getSpeed();
		else if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.getSpeed();
		else if (y + ya < 0)
			ya = game.getSpeed();
		else if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			ya = -game.getSpeed();
			y = game.getRacquet().getTopY() - DIAMETER;
			game.setSpeed(game.getSpeed()+1);;
		} //else 
			//changeDirection = false;
		
		//if (changeDirection) 
			//Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.getRacquet().getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}