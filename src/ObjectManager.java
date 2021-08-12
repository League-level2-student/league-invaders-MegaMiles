import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Rocketship rocket;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	Random random = new Random();
public ObjectManager(Rocketship rocket) {
	this.rocket = rocket;
	addAlien();
}
public void addAlien() {
	aliens.add(new Alien(random.nextInt(LeagueInvaders.Width),0,50,50));
}
public void update() {
	for (int i = 0; i < aliens.size(); i++) {
		aliens.get(i).update();
		if (aliens.get(i).y >= LeagueInvaders.Length) {
			aliens.get(i).isActive = false;
		}
	}
	for (int i = 0; i < projectiles.size(); i++) {
		projectiles.get(i).update();
		if (projectiles.get(i).y <= 0) {
			projectiles.get(i).isActive = false;
		}
	}
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
	
}
public void purgeObjects() {
for (int i = aliens.size()-1; i > -1; i--) {
	if (!aliens.get(i).isActive) {
	aliens.remove(aliens.get(i));
	}
}
for (int i = projectiles.size()-1; i > -1; i--) {
	if (!projectiles.get(i).isActive) {
		projectiles.remove(projectiles.get(i));
	}
}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}


}