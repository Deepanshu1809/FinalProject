package finalProject;

import javax.swing.JFrame;


public class Game {

	public static void main(String[] args) {
		// TODO Austo-generated method stub
		JFrame obj = new JFrame();
		GamePlay gp = new GamePlay();
		obj.setBounds(500, 50, 1000, 1000);
		obj.setTitle("Shoot it");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gp);
		
		
		
		
	}
	
	
}


