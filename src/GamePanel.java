import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CurrentState = MENU_STATE;
	ObjectManager o1;
	Timer t1;
	Font titleFont;
	Font titleFont2;
	Font titleFont3;
	Font titleFont4;
	Font titleFont5;
	Font titleFont6;
	public static BufferedImage alienImg;

	public static BufferedImage rocketImg;

	public static BufferedImage bulletImg;

	public static BufferedImage spaceImg;

	Rocketship r1 = new Rocketship(250, 700, 50, 50);

	public GamePanel() {
		titleFont = new Font("Alegreya", Font.PLAIN, 48);
		titleFont2 = new Font("Alegreya", Font.PLAIN, 24);
		titleFont3 = new Font("Alegreya", Font.PLAIN, 24);
		titleFont4 = new Font("Alegreya", Font.PLAIN, 48);
		titleFont5 = new Font("Alegreya", Font.PLAIN, 24);
		titleFont6 = new Font("Alegreya", Font.PLAIN, 24);
		t1 = new Timer(1000 / 60, this);
		o1 = new ObjectManager(r1);
		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));

			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));

			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));

			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (CurrentState == MENU_STATE) {
			updateMenu();
		} else if (CurrentState == GAME_STATE) {
			updateGameState();
		} else if (CurrentState == END_STATE) {
			updateEndState();
		}
	}

	@Override

	public void paintComponent(Graphics g) {
		if (CurrentState == MENU_STATE) {
			drawMenu(g);
		} else if (CurrentState == GAME_STATE) {
			drawGameState(g);
		} else if (CurrentState == END_STATE) {
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
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			CurrentState += 1;
			System.out.println(r1.isAlive);
		}
		if (CurrentState > END_STATE) {

			CurrentState = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			r1.rup = true;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			r1.rdown = true;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			r1.rright = true;
			System.out.println("up");

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			r1.rleft = true;
			System.out.println("up");
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			o1.addProjectile(new Projectiles(r1.x, r1.y, 10, 10));
		}
	}

	@Override
	public void keyReleased(KeyEvent a) {
		// TODO Auto-generated method stub
		r1.rup = false;
		r1.rdown = false;
		r1.rright = false;
		r1.rleft = false;
	}

	void updateMenu() {
		r1 = new Rocketship(250, 700, 50, 50);
		o1 = new ObjectManager(r1);
		r1.isAlive = true;
	}

	void drawMenu(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("LEAGUE INVADERS", 30, 200);
		g.setFont(titleFont2);
		g.drawString("Press ENTER to start", 120, 400);
		g.setFont(titleFont3);
		g.drawString("Press SPACE for instructions", 70, 600);
	}

	void updateGameState() {

		o1.update();
		o1.manageEnemies1();
		o1.checkCollision();
		o1.purgeObjects();
		if (r1.isAlive == false) {
			CurrentState = END_STATE;

		}
		if (CurrentState != END_STATE) {
			r1.isAlive = true;
		}
	}

	void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, 0, 0, 500, 800, null);
		o1.draw(g);
	}

	void updateEndState() {

	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, 500, 800);
		g.setFont(titleFont4);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 110, 200);
		g.setFont(titleFont5);
		g.drawString("You killed " + o1.score + " enemies", 130, 400);
		g.setFont(titleFont6);
		g.drawString("Press ENTER to restart", 115, 600);
	}
}
