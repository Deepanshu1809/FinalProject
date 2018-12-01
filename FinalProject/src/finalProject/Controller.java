package finalProject;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Controller {

	private ArrayList<Bullet> b = new ArrayList<Bullet>();
	private ArrayList<Rectangle> rb = new ArrayList<Rectangle>();

	Bullet TempBullet  ;
	Rectangle tb;
	
	GamePlay game;
	
	
	public Controller(GamePlay game) {
		
		this.game = game;
	}
	
	public void tick() {
		for(int i = 0 ; i<b.size(); i++) {
			TempBullet = b.get(i);
			
			TempBullet.tick();
			
			
			
		}
		
		for(int j = 0 ; j<rb.size(); j++) {
			tb =rb.get(j);
			
			tb.y -= 30;
			
			
			
		}
		
	}
	
	public void paint(Graphics g) {
		
		for(int i = 0 ; i<b.size(); i++) {
			TempBullet = b.get(i);
			
			TempBullet.paint(g);
			
			
			
			
			
		}
		
		
		for(Rectangle w : rb) {
			
			g.drawRect(w.x,w.y,w.width,w.height);
		}
		
	}
	
	public ArrayList<Rectangle> getList(){
		return rb;
	}
	public ArrayList<Bullet> getLst(){
		return b;
	}
	
	public void addBullet(Bullet block,Rectangle rc) {
		
		b.add(block);
		rb.add(rc);
	}
	
	
	public void removeBullet(Bullet block , Rectangle rc) {
		
		
		b.remove(block);
		rb.remove(rc);
	}
}
