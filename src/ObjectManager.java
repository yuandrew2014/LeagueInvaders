import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	long enemyTimer;
	int enemySpawnTime;
Rocketship r1;
ArrayList<Alien>alien = new ArrayList<Alien>();
ArrayList<Projectiles>projectiles = new ArrayList<>();
ObjectManager(Rocketship r1, long enemyTimer, int  enemySpawnTime){
	this.r1 = r1;
	this.enemyTimer = enemyTimer;
	this.enemySpawnTime =  + 3000;
}
void update() {
	r1.update();
	for(Projectiles e: projectiles) {
		e.update();
	}
	for(Alien a: alien) {
		a.update();
	}
}
void draw(Graphics g) {
	r1.draw(g);
	for(Projectiles e: projectiles) {
		e.draw(g);
	}
	for(Alien a: alien) {
		a.draw(g);
	}
}

 void addProjectile(Projectiles Projectile) {
	 projectiles.add(Projectile);
 }
 void addAlien(Alien a) {
	alien.add(a);
 }
 void manageEnemies() {
	 
 }
 public void manageEnemies1(){
     if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
             addAlien(new Alien(new Random().nextInt(leagueInvaders1.gamewidth), 0, 50, 50));

enemyTimer = System.currentTimeMillis();
     }
}
 void purgeObjects() {
	 
 }
}


