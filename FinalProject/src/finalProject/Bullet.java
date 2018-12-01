package finalProject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Bullet {
	
	private int x ;
	private int y ;
	BufferedImage i1 ;
	
	
	
	
	public Bullet(int x , int y ) {
		
		this.x = x;
		this.y = y;
		
		
		
		 
	
	}
	
	public void tick() {
		y-=30;
		
		 //y = y + 50 ;
	}
	
	public void paint(Graphics g) {
		try {
			i1 = ImageIO.read(Bullet.class.getResource("/imgs/bullet_1.png"));
		}catch(Exception e) {
			e.getMessage();
		}
		
		g.drawImage(i1,(int)x , (int)y , 20 , 30,null);
	}

}
