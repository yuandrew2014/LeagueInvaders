import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CurrentState = MENU_STATE;
	Timer t1;
	Font titleFont;
	public GamePanel() {
		titleFont = new Font("Aleygra",Font.PLAIN,48);
		 t1 = new Timer(1000/60, this);
		 


	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
	if(CurrentState == MENU_STATE) {
		updateMenu();
	}
	else if(CurrentState == GAME_STATE) {
	updateGameState();
	}
	else if(CurrentState == END_STATE) {
		updateEndState();
	}
}
@Override

public void paintComponent(Graphics g){
	if(CurrentState == MENU_STATE) {
		drawMenu(g);
	}
	else if(CurrentState == GAME_STATE) {
	drawGameState(g);
	}
	else if(CurrentState == END_STATE) {
		drawEndState(g);
	}
}
              
       
void startGame() {
	t1.start();
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		System.out.println(CurrentState);
	CurrentState +=1;
	if(CurrentState > END_STATE){

        CurrentState = MENU_STATE;
	}
}
}
@Override
public void keyReleased(KeyEvent a) {
	// TODO Auto-generated method stub
	
	

}
void updateMenu() {
	

}
void drawMenu(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0,0,500,800);
	g.setFont(titleFont);
	g.setColor(Color.WHITE);
	g.drawString("ii luv pi", 180, 400);
}
void updateGameState() {
	

}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0,0,500,800);
	
}
void updateEndState() {
	
	
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0,500,800);
}
}

