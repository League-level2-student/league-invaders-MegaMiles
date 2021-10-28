import java.util.Random;

public class DiagonalAlien extends Alien{
	int xSpeed = 2;
	Random ran = new Random();
	public DiagonalAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		needImage = true;
		gotImage = false;
if (ran.nextBoolean()) {
xSpeed = -2;	
}	
		if (needImage) {
		    loadImage ("DiagonalAlien.png");
		}
	}
	public void	update(){
		super.update();
		if(x >= LeagueInvaders.WIDTH-width || x <= 0) {
			xSpeed = -xSpeed;
		}
		x+=xSpeed;	
	}
	
}
