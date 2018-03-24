import java.awt.Color;
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
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		System.out.println(y);
	}
}
