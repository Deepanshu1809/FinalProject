package finalProject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;


public class GamePlay extends JPanel implements KeyListener , ActionListener {

	Timer t;
	Random r = new Random();
	
	
	
	private Controller c;
	
	
	
	int x1 , y1 , x2 , y2 , x3 , y3 , x4 , y4 , x5 , y5 , x6 , y6 ;
	int p_x = 500 , p_y =850;
	int b_x , b_y;
	int delay = 400 ;
	
	
	
	
	
	
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		t = new Timer(delay,this);
		t.start();
		
		c = new Controller(this);
		
		
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
		
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		
		g.fillOval(x1, y1, 20, 20);
		g.fillOval(x2, y2, 30, 30);
		g.fillOval(x3, y3, 40, 40);
		g.fillOval(x4, y4, 50, 50);			// GoBlins
		g.fillOval(x5, y5, 60, 60);
		g.fillOval(x6, y6, 70, 70);
		
		
		
		
		
		g.fillRect(b_x, b_y, 20, 20);
		
		c.paint(g);
		
		
		g.fillRect(p_x, p_y, 100, 100);   // GUN
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 int myKey = arg0.getKeyCode();
		 
		 if(myKey == arg0.VK_ENTER) {
			 
			 c.addBullet(new Bullet(p_x , p_y ));
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
		
		Random();
		b_y -= 40 ;
		tick();
		repaint();
	}
	
	
	
	

}
