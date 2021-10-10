

public class ShootingAlien extends Alien{


	public ShootingAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		needImage = true;
		gotImage = false;	
		if (needImage) {
		    loadImage ("ShootingAlien.png");
		}
	}
	public void	update(){
		super.update();
	
	}
	
}

