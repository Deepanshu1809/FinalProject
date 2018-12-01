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
	
	
	
	Boolean delete;
	
	
	ArrayList<Rectangle> goblins;
	
	BufferedImage i1  , g1 , gun , go;
	Rectangle player;
	
	private Controller c;
	
	
	
	int x1 , y1 , x2 , y2 , x3 , y3 , x4 , y4 , x5 , y5 , x6 , y6 ;
	int p_x = 500 , p_y =850;
	//int b_x , b_y;
	int delay = 1 ;
	int del =1000;
	
	
	
	
	
	
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
	public void check() {
		a=p_x;
		b=p_y;
	}
	static int a,b;
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
		//goblins.add(new Rectangle(x2,-10,50,50));
		//goblins.add(new Rectangle(x3,-10,50,50));
		/*goblins.add(new Rectangle(x4,-10,50,50));
		goblins.add(new Rectangle(x5,-10,50,50));
		goblins.add(new Rectangle(x6,-10,50,50));*/
		
		player = new Rectangle(p_x,p_y,100,100);
	
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		try {
			i1 = ImageIO.read(Bullet.class.getResource("/imgs/bg.png"));
			g1 = ImageIO.read(Bullet.class.getResource("/imgs/g1.png"));
			gun = ImageIO.read(Bullet.class.getResource("/imgs/gun.png"));
			go = ImageIO.read(Bullet.class.getResource("/imgs/GameOver.jpg"));
		}catch(Exception e) {
			e.getMessage();
		}
		g.drawImage(i1,0,0,1000,1000,null);
		
		
		
		for(Rectangle r:goblins) {
			g.drawImage(g1,r.x, r.y, r.width, r.height,null);
		}
		
		
		
		
		//g.fillRect(b_x, b_y, 20, 20);
		
		c.paint(g);
		
		if(delete == false) {
		g.drawImage(gun,p_x, p_y, 100, 100,null);   // GUN
		}
		
		if(delete == true) {
			g.drawImage(go,a,b,100,100,null);
			
			
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		 int myKey = arg0.getKeyCode();
		 
		 if(myKey == arg0.VK_ENTER) {
			 
			 c.addBullet(new Bullet(p_x+50 , p_y ),new Rectangle(p_x+50,p_y,20,30));
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
			Random();									//RANDOMLY GENERATING
			repaint();									//GOBLINS	
				
		}
		
		
		 delete = false;
		
		
		Rectangle myithgoblin , bullet , gbln;
		
		ArrayList<Rectangle> bul=new ArrayList<>();
		ArrayList<Bullet> bl=new ArrayList<>();
		bul=c.getList();
		bl = c.getLst();
		Bullet m;
		
		if(arg0.getSource() == l) {
			
			for(int i=0;i<goblins.size();i++) {				//MOTION OF
				myithgoblin=goblins.get(i);				 	//GOBLINS		
				myithgoblin.y+=50;
			}
			
			
				
			
			repaint();
			
		}
		
		
		tick();												// MOTION OF BULLETS
		
		
		
		
		for(int i=0;i<goblins.size();i++) {
			myithgoblin=goblins.get(i);						// COLLISION
		for(int j=0;j<bul.size();j++) {						//BETWEEN
			bullet=bul.get(j);								//BULLET
			m=bl.get(j);									//AND
			if(myithgoblin.intersects(bullet))				//GOBLINS
			{
			goblins.remove(myithgoblin);
			c.removeBullet(m,bullet);
			}
		}
		}
		
		
		
		for(int k=0;k<goblins.size();k++) {
			
			gbln =goblins.get(k);
			
			if(gbln.intersects(player) || gbln.y >= p_y) {
				delete =true;
				check();
				t.stop();
				g.stop();
				l.stop();
				repaint();
			}
			
		}
		
	
		repaint();
	}
	
	
	
	

}
