import java.awt.Graphics;

public class Projectiles extends GameObject {
	int speed;

	Projectiles(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.height = height;
		this.x = x + 10;

		this.y = y;

		this.width = width;
		speed = 10;
	}

	void update() {
		super.update();
		y -= speed;
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.bulletImg, x, y, width, height, null);

	}
}
