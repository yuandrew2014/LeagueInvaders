import javax.swing.JFrame;

public class leagueInvaders1 {
	int gamewidth = 500;
	int gamelength = 800;
public static void main(String[] args) {
	leagueInvaders1 l1 = new leagueInvaders1();
	l1.v1();
	l1.setup();
}
JFrame f1 = new JFrame();
 void v1() {
	 f1.setVisible(true);
	 f1.pack();
	 
 }
 void setup() {
	 f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	 
	 
 }
}
