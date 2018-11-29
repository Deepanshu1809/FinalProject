package finalProject;

import java.awt.Graphics;

public class Bullet {
	
	private int x ;
	private int y ;
	
	
	public Bullet(int x , int y ) {
		
		this.x = x;
		this.y = y;
		 
	
	}
	
	public void tick() {
		y-=10;
	}
	
	public void paint(Graphics g) {
		
		g.fillRect((int)x , (int)y , 20 , 20);
	}

}
