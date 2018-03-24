import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	int Random = new java.util.Random().nextInt(10);
	// int Random2 = new java.util.Random().nextInt(10) * -1;

	Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.height = height;
		this.x = x;
		this.y = y;
		this.width = width;
	}

	void update() {
		super.update();
		y += Random;
		// y += Random;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
