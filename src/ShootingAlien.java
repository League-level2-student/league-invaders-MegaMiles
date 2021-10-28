import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ShootingAlien extends Alien implements ActionListener{
	Timer alienBullet;
	Boolean cooldown = false;
	public ShootingAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		needImage = true;
		gotImage = false;	
		if (needImage) {
		    loadImage ("ShootingAlien.png");
		}
		    alienBullet = new Timer(600 , this);
		    alienBullet.start();	
	}
	public Alien_Projectile getProjectile() {
		cooldown = false;
        return new Alien_Projectile(x+width/2, y, 10, 10);
}
	
	public void	update(){
		super.update();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	cooldown = true;
	}
	
}

