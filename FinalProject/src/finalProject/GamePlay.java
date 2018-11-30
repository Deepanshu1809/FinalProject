package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;


public class GamePlay extends JPanel implements KeyListener , ActionListener {

	Timer t , g , l;
	Random r = new Random();
	
	ArrayList<Rectangle> goblins;
	
	BufferedImage i1  , g1 , gun;
	
	private Controller c;
	
	
	
	int x1 , y1 , x2 , y2 , x3 , y3 , x4 , y4 , x5 , y5 , x6 , y6 ;
	int p_x = 500 , p_y =850;
	//int b_x , b_y;
	int delay = 1 ;
	int del = 300;
	
	
	
	
	
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		t = new Timer(delay,this);
		g = new Timer(800,this);
		l = new Timer(del,this);
		t.start();
		g.start();
		l.start();
		c = new Controller(this);
		
		goblins=new ArrayList<Rectangle>();
		//Random();

		
	}
	
	public void tick() {
		c.tick();
		
	}
	public void Random() {
		
		x1 = r.nextInt(900);
		x2 = r.nextInt(900);
		x3 = r.nextInt(900);
		x4 = r.nextInt(900);
		x5 = r.nextInt(900);
		x6 = r.nextInt(900);
		
		
		
		
		
		y1 = r.nextInt(400);
		y2 = r.nextInt(400);
		y3 = r.nextInt(400);
		y4 = r.nextInt(400);
		y5 = r.nextInt(400);
		y6 = r.nextInt(400);
		
		
		
		
		goblins.add(new Rectangle(x1,-10,50,50));
		goblins.add(new Rectangle(x2,-10,50,50));
		goblins.add(new Rectangle(x3,-10,50,50));
		/*goblins.add(new Rectangle(x4,-10,50,50));
		goblins.add(new Rectangle(x5,-10,50,50));
		goblins.add(new Rectangle(x6,-10,50,50));*/
	
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		try {
			i1 = ImageIO.read(Bullet.class.getResource("/imgs/bg.png"));
			g1 = ImageIO.read(Bullet.class.getResource("/imgs/g1.png"));
			gun = ImageIO.read(Bullet.class.getResource("/imgs/gun.png"));
		}catch(Exception e) {
			e.getMessage();
		}
		g.drawImage(i1,0,0,1000,1000,null);
		
		/*g.fillOval(x1, y1, 20, 20);
		g.fillOval(x2, y2, 30, 30);
		g.fillOval(x3, y3, 40, 40);
		g.fillOval(x4, y4, 50, 50);			// GoBlins
		g.fillOval(x5, y5, 60, 60);
		g.fillOval(x6, y6, 70, 70);
		*/
		
		
		for(Rectangle r:goblins) {
			g.drawImage(g1,r.x, r.y, r.width, r.height,null);
		}
		
		
		
		
		//g.fillRect(b_x, b_y, 20, 20);
		
		c.paint(g);
		
		
		g.drawImage(gun,p_x, p_y, 100, 100,null);   // GUN
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 int myKey = arg0.getKeyCode();
		 
		 if(myKey == arg0.VK_ENTER) {
			 
			 c.addBullet(new Bullet(p_x+50 , p_y ));
			 }
		 if(myKey == arg0.VK_LEFT) {
			 if(p_x <= 50) {
				 p_x = 50;
			 }else {
				 moveLeft();
			 }
			 
			 repaint();
			 
		 }
		 
		 
		 if(myKey == arg0.VK_RIGHT) {
			 if(p_x >= 850) {
				 p_x =850;
			 }else {
				 moveRight();
			 }
			 
			 repaint();
			 
		 }
		 
		 
		// repaint();
		 
	}

	
	
	public void moveLeft() { 
		p_x -= 50;
	}
	
	
	public void moveRight() { 
		p_x += 50;
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource() == g) {
			Random();
			repaint();
				
		}
		
		if(arg0.getSource() == l) {
			Rectangle myithgoblin , bullet;
			
			for(int i=0;i<goblins.size();i++) {
				myithgoblin=goblins.get(i);
				myithgoblin.y+=20;
				//if(myithgoblin.intersects(bullet)) {
					
				//}
			}
			repaint();
			
		}
		
		//b_y -= 100 ;
		tick();
		repaint();
	}
	
	
	
	

}
