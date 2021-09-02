import java.awt.Color;
import java.awt.Graphics;

public class Button extends GameObject{
	Color color;
	String Powerup;
	public Boolean isClicked(int MouseX, int MouseY) {
	return MouseX > x && MouseY > y && MouseX < width+x && MouseY < height+y; 
	}
	public Button(int x, int y, int width, int height, Color color, String Powerup) {
		super(x, y, width, height);
		 this.color = color;
		 this.Powerup = Powerup;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
	
}
