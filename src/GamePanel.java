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
	Font titleFont2;
	Font titleFont3;
	Font titleFont4;
	Font titleFont5;
	Font titleFont6;
	Rocketship r1 = new Rocketship(250,700,50,50);
	public GamePanel() {
		titleFont = new Font("Alegreya",Font.PLAIN,48);
		titleFont2= new Font("Alegreya",Font.PLAIN,24);
		titleFont3= new Font("Alegreya",Font.PLAIN,24);
		titleFont4 = new Font("Alegreya",Font.PLAIN,48);
		titleFont5= new Font("Alegreya",Font.PLAIN,24);
		titleFont6= new Font("Alegreya",Font.PLAIN,24);
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
	if(e.getKeyCode()==KeyEvent.VK_UP) {
		r1.x+= 100;
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
	g.drawString("LEAGUE INVADERS", 30, 200);
	g.setFont(titleFont2);
	g.drawString("Press ENTER to start", 120, 400);
	g.setFont(titleFont3);
	g.drawString("Press SPACE for instructions", 70, 600);
}
void updateGameState() {
	r1.update();

}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0,0,500,800);
	r1.draw(g);
}
void updateEndState() {
	
	
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0,500,800);
	g.setFont(titleFont4);
	g.setColor(Color.BLACK);
	g.drawString("GAME OVER", 110,200);
	g.setFont(titleFont5);
	g.drawString("You killed"+" enemies", 130, 400);
	g.setFont(titleFont6);
	g.drawString("Press ENTER to restart", 115, 600);
}
}

