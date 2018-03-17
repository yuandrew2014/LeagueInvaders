import java.awt.Dimension;

import javax.swing.JFrame;

public class leagueInvaders1 {
	static int gamewidth = 500;
	static int gamelength = 800;
public static void main(String[] args) {
	leagueInvaders1 l1 = new leagueInvaders1();
	l1.v1();
	l1.setup();
	
}
GamePanel g1 = new GamePanel();
JFrame f1 = new JFrame();
 void v1() {
	 f1.setVisible(true);
	 f1.getContentPane().setPreferredSize(new Dimension(gamewidth, gamelength));
f1.addKeyListener(g1);
     


	 f1.pack();
	 
 }
 void setup() {
	 f1.add(g1);
	 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 g1.startGame();
	 
 }
}
