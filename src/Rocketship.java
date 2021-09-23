import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Rocketship extends GameObject { 
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	static int Hyperspeed = 0;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	static int Lives_Amount = 1;
	int Lives_Remaining;
	public Rocketship(int x, int y, int width, int height, int Lives_Remaining){
		super(x,y,width,height);
		this.Lives_Remaining = Lives_Remaining;
		speed = 7;
		if (needImage) {
		    loadImage ("rocket.png"); 
		}
	}
	public Projectile getProjectile() {
        return new Projectile(x+width/2, y, 10, 10, Projectile.Projectile_Durability);
}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        needImage = false;
	    }
	}
	 public void up() {     
	    if (y>=0) {
	    		y-=speed + Hyperspeed;
}
	    }
	 public void down() {
	      if (y<=717) {  
	    	  	y+=speed + Hyperspeed;
	    }	    
}
	 public void left() {
	        if (x>=0) {
	        	x-=speed + Hyperspeed;	
		}
}
	 public void right() {
	       if (x<=450) {
	    	    x+=speed + Hyperspeed;	
		} 
}
	 public void update(){
	if (up) {
	up();	
	}
	if (down) {
	down();	
	}
	if (left) {
	left();	
	}
	if (right) {
	right();	
	}
	
	super.update();
	 }
	void draw(Graphics g) {
		//g.setColor(Color.BLUE);
        //g.fillRect(x, y, width, height);
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
	}
}
