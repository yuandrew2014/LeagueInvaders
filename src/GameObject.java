import java.awt.Graphics;

public class GameObject {
int x;

int y;
int width;
int height;
public GameObject(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}

void update() {
	
}
void draw(Graphics g) {
	g.drawRect(10,10,100,100);
}
}

