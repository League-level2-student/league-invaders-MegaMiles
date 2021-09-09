import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Button extends GameObject{
	Color color;
	String Powerup;
	public BufferedImage image;
	public boolean needImage = true;
	public boolean gotImage = false;
	public Boolean isClicked(int MouseX, int MouseY) {
	return MouseX > x && MouseY > y && MouseX < width+x && MouseY < height+y; 
	}
	public Button(int x, int y, int width, int height, Color color, String Powerup) {
		super(x, y, width, height);
		 this.color = color;
		 this.Powerup = Powerup;
		 if (needImage) {
			    
			    if (Powerup.equals("Molasses")) {
			    loadImage ("Molasses.png");	
				}
			    if (Powerup.equals("Hyperdrive Module")) {
				    loadImage ("Engine.png");	
					}
			    if (Powerup.equals("Sharper Projectiles")) {
				    loadImage ("Projectile.png");	
					}
			    if (Powerup.equals("Molasses")) {
				    loadImage ("Molasses.png");	
					}
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
}}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		if(Powerup.equals("Molasses")) {
		g.drawImage(image, 110, 240, 95, 95, null);
		}
		if(Powerup.equals("Hyperdrive Module")) {
		g.drawImage(image, 293, 250, 110, 95, null);
		}
		if(Powerup.equals("Sharper Projectiles")) {
		g.drawImage(image, 90, 491, 130, 95, null);
		}
	}
	
}
