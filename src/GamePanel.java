import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener {
	
	Timer t1;
GameObject o1;
	public GamePanel() {
	
		 t1 = new Timer(1000/60, this);
		 

 o1 = new GameObject(10, 10, 100, 100);
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	
	
}
@Override

public void paintComponent(Graphics g){
o1.draw(g);
               

       }
void startGame() {
	t1.start();
	
}
@Override
public void keyTyped(KeyEvent a) {
	// TODO Auto-generated method stub
	System.out.println("lol");
}
@Override
public void keyPressed(KeyEvent a) {
	// TODO Auto-generated method stub
	System.out.println("hi");
}
@Override
public void keyReleased(KeyEvent a) {
	// TODO Auto-generated method stub
	System.out.println("i like pi");
}
}

