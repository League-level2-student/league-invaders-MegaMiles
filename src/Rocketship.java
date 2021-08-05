import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject { 
	boolean up = false;
	boolean down = false;
	boolean left = false;
	boolean right = false;
	public Rocketship(int x, int y, int width, int height){
		super(x,y,width,height);
		speed = 12;
		
	}
	 public void up() {     
	    if (y>=0) {
	    		y-=speed;
}
	    }
	 public void down() {
	      if (y<=717) {  
	    	  	y+=speed;
	    }	    
}
	 public void left() {
	        if (x>=0) {
	        	x-=speed;	
		}
}
	 public void right() {
	       if (x<=440) {
	    	    x+=speed;	
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
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
	}
}
