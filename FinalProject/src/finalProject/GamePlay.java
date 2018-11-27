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
	int x1 , y1 , x2 , y2 , x3 , y3 , x4 , y4 , x5 , y5 , x6 , y6 ;
	int p_x , p_y;
	int b_x , b_y;
	int delay = 400 ;
	
	
	
	
	
	
	
	public GamePlay() {
		addKeyListener(this);
		setFocusable(true);
		t = new Timer(delay,this);
		t.start();
		
		
	}
	
	public void Random() {
		
		
	}
	
	public void paint(Graphics g) {
		g.fillRect(200, 200, 100, 100);
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
	}
	
	
	
	

}
