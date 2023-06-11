package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Graphics
extends JPanel
implements ActionListener{
	private Timer t = new Timer(100, this);
	public String state;
	
	private Snake s;
	private Food f;
	private game game;
	
	public Graphics(game g) {
		t.start();
		state = "START";
		
		game = g;
		s = g.getPlayer();
		f = g.getFood();
		
		//add a keyListner 
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, game.width * game.dimension + 5, game.height * game.dimension + 5);
		
		if(state == "START") {
			g2d.setColor(Color.black);
			g2d.drawString("Press Anythings", game.width/2 * game.dimension - 40, game.height / 2 * game.dimension - 20);
		}
		else if(state == "RUNNING") {
			g2d.setColor(Color.orange);
			g2d.fillRect(f.getX() * game.dimension, f.getY() * game.dimension, game.dimension, game.dimension);
		
			g2d.setColor(Color.black);
			for(Rectangle r : s.getBody()) {
				g2d.fill(r);
			}
		}
		else {
			g2d.setColor(Color.black);
			g2d.drawString("Your Score: " + (s.getBody().size() - 3), game.width/2 * game.dimension - 40, game.height / 2 * game.dimension - 20);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		game.update();
	}
	
}
