import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject { 
	boolean rup = false;
	boolean rdown = false;
	boolean rright = false;
	boolean rleft = false;
int speed;
Rocketship(int x, int y, int width, int height){
	super(x,y,width,height);
	this.height = height;
	this.x = x;
	this.y = y;
	this.width = width;
	speed = 5;
}
void update() {
	
	if(rup == true) {
		System.out.println(rup);
		x-=5;
	}
	if(rdown == true) {
		x +=5;
	}
	if(rright == true) {
		y+=5;
	}
	if(rleft == true) {
		y-=5;
	}
}
void draw(Graphics g) {
	  g.setColor(Color.BLUE);

      g.fillRect(x,y,width,height);
}

}
