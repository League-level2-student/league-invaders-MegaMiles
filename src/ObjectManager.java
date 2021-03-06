import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	ArrayList<Alien_Projectile> alienProjectiles = new ArrayList<Alien_Projectile>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();

	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;

	}

	public void checkCollision() {
		for (int i = aliens.size() - 1; i > -1; i--) {
			if (rocket.collisionbox.intersects(aliens.get(i).collisionbox)) {
				aliens.get(i).isActive = false;
				rocket.Lives_Remaining--;
			}
			for (int j = 0; j < projectiles.size(); j++) {
				if (projectiles.get(j).collisionbox.intersects(aliens.get(i).collisionbox) && aliens.get(i) instanceof TankAlien) {
					projectiles.get(j).Remaining_Durability--;

					if (projectiles.get(j).Remaining_Durability == 0) {
						projectiles.get(j).isActive = false;
					}
					((TankAlien) aliens.get(i)).ALIENLives_Remaining--;
				if (((TankAlien) aliens.get(i)).ALIENLives_Remaining <= 0) {
				aliens.get(i).isActive = false;	
				}
				}
				else if (projectiles.get(j).collisionbox.intersects(aliens.get(i).collisionbox) && !(aliens.get(i) instanceof TankAlien)) {
					GamePanel.score++;
					aliens.get(i).isActive = false;
					projectiles.get(j).Remaining_Durability--;

					if (projectiles.get(j).Remaining_Durability == 0) {
						projectiles.get(j).isActive = false;
					}
				}
			}

		}
		for (int i = 0; i < alienProjectiles.size(); i++) {
			if (alienProjectiles.get(i).collisionbox.intersects(rocket.collisionbox)) {
				rocket.Lives_Remaining--;
				alienProjectiles.get(i).isActive = false;
				if (rocket.Lives_Remaining <= 0) {
					rocket.isActive = false;
				}
			}
		}
	}

	public void addprojectile(Projectile p) {
		projectiles.add(p);
	}

	public void addAlien() {
		int alienSelector = random.nextInt(Rocketship.ExtraLife_Bought + 1);
		if (alienSelector == 0) {
			aliens.add(new Alien(random.nextInt(401) + 50, 0, 50, 50));
		}
		if (alienSelector == 1) {
			aliens.add(new DiagonalAlien(random.nextInt(401) + 50, 0, 50, 50));
		}
		if (alienSelector == 2) {
			aliens.add(new ShootingAlien(random.nextInt(401) + 50, 0, 50, 50));
		}
		if (alienSelector == 3) {
			aliens.add(new TankAlien(random.nextInt(401) + 50, 0, 50, 50));
		}

	}

	public void update() {
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
			if (aliens.get(i).y >= LeagueInvaders.LENGTH) {
				rocket.Lives_Remaining--;
				aliens.get(i).isActive = false;
			}
			if (aliens.get(i) instanceof ShootingAlien && ((ShootingAlien) aliens.get(i)).cooldown) {
				alienProjectiles.add(((ShootingAlien) aliens.get(i)).getProjectile());
			}
		}
		if (rocket.Lives_Remaining <= 0) {
			rocket.isActive = false;
		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
			if (projectiles.get(i).y <= 0) {
				projectiles.get(i).isActive = false;
			}
		}
		for (int i = 0; i < alienProjectiles.size(); i++) {
			alienProjectiles.get(i).update();
			if (alienProjectiles.get(i).y >= 800) {
				alienProjectiles.get(i).isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
		rocket.update();
	}

	public void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

		for (int o = 0; o < projectiles.size(); o++) {
			projectiles.get(o).draw(g);
		}

		for (int o = 0; o < alienProjectiles.size(); o++) {
			alienProjectiles.get(o).draw(g);
		}

	}

	public void purgeObjects() {
		for (int i = aliens.size() - 1; i > -1; i--) {
			if (!aliens.get(i).isActive) {
				aliens.remove(aliens.get(i));
			}
		}
		for (int i = projectiles.size() - 1; i > -1; i--) {
			if (!projectiles.get(i).isActive) {
				projectiles.remove(projectiles.get(i));

			}
		}
		for (int i = alienProjectiles.size() - 1; i > -1; i--) {
			if (!alienProjectiles.get(i).isActive) {
				alienProjectiles.remove(alienProjectiles.get(i));
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		addAlien();
	}

}