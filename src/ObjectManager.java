import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	boolean alienDead = false;
	boolean projectileDead = false;
	long enemyTimer;
	int enemySpawnTime;
	Rocketship r1;
	ArrayList<Alien> alien = new ArrayList<Alien>();
	ArrayList<Projectiles> projectiles = new ArrayList<>();

	ObjectManager(Rocketship r1) {
		this.r1 = r1;
		this.enemySpawnTime = +500;
	}

	void update() {
		r1.update();
		for (Projectiles e : projectiles) {
			e.update();
		}
		for (Alien a : alien) {
			a.update();
		}
	}

	void draw(Graphics g) {
		r1.draw(g);
		for (Projectiles e : projectiles) {
			e.draw(g);
		}
		for (Alien a : alien) {
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

	public void manageEnemies1() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(leagueInvaders1.gamewidth), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	void purgeObjects() {

		for (int i = 0; i < alien.size(); i++) {

			if (alien.get(i).isAlive == false) {
				alien.remove(i);
			}
		}
	}

	void checkCollision() {
		for (Alien a : alien) {
			for (Projectiles p : projectiles) {
				if (p.collisionBox.intersects(a.collisionBox)) {
					p.isAlive = false;
					a.isAlive = false;
				}

			}

			if (r1.collisionBox.intersects(a.collisionBox)) {
				System.out.println("alien is dead");
				r1.isAlive = false;

			}

		}
	}
}
