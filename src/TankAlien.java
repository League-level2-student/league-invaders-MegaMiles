
public class TankAlien extends Alien{
int ALIENLives_Remaining = 3;
	public TankAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		needImage = true;
		gotImage = false;
		if (needImage) {
		    loadImage ("TankAlien.png");
		}
	}
	public void	update(){
		super.update();
			
	}
	
}
