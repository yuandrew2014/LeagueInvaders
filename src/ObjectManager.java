import java.awt.Graphics;

public class ObjectManager {
Rocketship r1;
ObjectManager(Rocketship r1){
	this.r1 = r1;
	
}
void update() {
	r1.update();
}
void draw(Graphics g) {
	r1.draw(g);
}
}
