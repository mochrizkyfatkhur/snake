package Game;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	private ArrayList<Rectangle> body;
	private int w = game.width;
	private int h = game.height;
	private int d = game.dimension;
	
	private String move; //NOTHING, UP, DOWN, LEFT, RIGHT
	
	public Snake() {
		body = new ArrayList<>();
		
		Rectangle temp = new Rectangle(game.dimension, game.dimension);
		temp.setLocation(game.width / 2 * game.dimension, game.height / 2 * game.dimension);
		body.add(temp);
		
		temp = new Rectangle(d, d);
		temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
		body.add(temp);
		
		temp = new Rectangle(d, d);
		temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
		body.add(temp);
		
		move = "NOTHING";
	}
	
	public void move() {
		if(move != "NOTHING") {
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle(game.dimension, game.dimension);
			
			if(move == "UP") {
				temp.setLocation(first.x, first.y - game.dimension);
			}
			else if(move == "DOWN") {
				temp.setLocation(first.x, first.y + game.dimension);
			}
			else if(move == "LEFT") {
				temp.setLocation(first.x - game.dimension, first.y);
			}
			else{
				temp.setLocation(first.x + game.dimension, first.y);
			}
			
			body.add(0, temp);
			body.remove(body.size()-1);
		}
	}
	
	public void grow() {
		Rectangle first = body.get(0);
		
		Rectangle temp = new Rectangle(game.dimension, game.dimension);
		
		if(move == "UP") {
			temp.setLocation(first.x, first.y - game.dimension);
		}
		else if(move == "DOWN") {
			temp.setLocation(first.x, first.y + game.dimension);
		}
		else if(move == "LEFT") {
			temp.setLocation(first.x - game.dimension, first.y);
		}
		else{
			temp.setLocation(first.x + game.dimension, first.y);
		}
		
		body.add(0, temp);
	}

	public ArrayList<Rectangle> getBody() {
		return body;
	}
	

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public int getX() {
		return body.get(0).x;
	}
	
	public int getY() {
		return body.get(0).y ;
	}
	
	public String getMove() {
		return move;
	}
	
	public void up() {
		move = "UP";
	}
	public void down() {
		move = "DOWN";
	}
	public void left() {
		move = "LEFT";
	}
	public void right() {
		move = "RIGHT";
	}
}