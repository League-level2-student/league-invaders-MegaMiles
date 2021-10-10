import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject{
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	static int MolassesLevel = 0;
	static int alien_score_price = 10;
	static int Molasses_Bought = 0;
	
	public Alien(int x, int y, int width, int height){
		super(x,y,width,height);
		
		speed = 5;
		if (needImage) {
		    loadImage ("Alien.png");
		}
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
	public void update() {
	y+=speed - MolassesLevel;
	
	 super.update();
	}
	void draw(Graphics g) {
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
}
