import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener, MouseListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
	int currentState = MENU;
	Font italic;
	Font titleFont;
	Font smallerfont;	
	Timer frameDraw;
	Timer alienSpawn;
	static int score = 0;
	Rocketship rocket = new Rocketship(250,700,50,50);
	ObjectManager ob = new ObjectManager(rocket);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
}

public int getScore() {
	return score;
}

public void startGame(){
    alienSpawn = new Timer(600 , ob);
    alienSpawn.start();	
}

	public GamePanel() {
		 titleFont = new Font("Oswald", Font.PLAIN, 35);	
		 smallerfont = new Font("New Times Roman", Font.PLAIN, 20);
		 italic = new Font("New Times Roman", Font.ITALIC, 35);
		 frameDraw = new Timer(1000/60,this);
		    frameDraw.start(); 
		loadImage("space.png");  
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
	void updateMenuState() {  
		
	}
	void updateGameState() {  
	ob.update();
	if (!rocket.isActive) {
	currentState = END;	
	}
	
	}
	void updateEndState()  {  
		
	}
	void drawMenuState(Graphics g) { 
		g.drawImage(image, 0, 0, LeagueInvaders.Width, LeagueInvaders.Length, null);
		g.setColor(Color.GRAY);
		g.fillRect(50, 50, 400, 700);
		g.setFont(titleFont);
		g.setColor(Color.CYAN);
		g.drawString("LEAGUE INVADERS", 96, 120);
		g.setFont(italic);
		g.drawString("UPGRADES", 146, 155);
		g.setFont(smallerfont);
		g.setColor(Color.WHITE);
		g.drawString("press ENTER to start", 136, 700);
		g.setFont(smallerfont);
		g.setColor(Color.GREEN);
		g.drawString("Score: " + getScore() + ".", 20, 20);
		g.setColor(Color.pink);
		g.fillRect(60, 170, 190, 250);
		g.setColor(Color.green);
		g.fillRect(250, 170, 190, 250);
		
		System.out.println("60, 170, 380, 250");
	}
	void drawGameState(Graphics g) {  
		g.drawImage(image, 0, 0, LeagueInvaders.Width, LeagueInvaders.Length, null);
		ob.draw(g);
		g.setColor(Color.GREEN);
		g.drawString("Score: " + getScore() + ".", 20, 20);
	}
	void drawEndState(Graphics g)  {  
		g.drawImage(image, 0, 0, LeagueInvaders.Width, LeagueInvaders.Length, null);
		g.setColor(Color.GRAY);
		g.fillRect(50, 50, 400, 700);
		currentState = MENU;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		
		repaint();
	}
	
	public void GameReset() {
	score = 0;	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_Q) {
		GameReset();	
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {   
				currentState = MENU;
		    }
			else if (currentState == MENU) {
				rocket = new Rocketship(250,700,50,50);
				 ob = new ObjectManager(rocket);
				currentState = GAME;
		    	startGame();
			}
			else if(currentState == GAME) {
		       currentState = END;
		    }
			
			
		   
		    
		}
		
		
		
		
		
		if (e.getKeyCode()==KeyEvent.VK_UP) {
	         rocket.up=true;
	    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 rocket.right=true;
	    }
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			 rocket.down=true;
	    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			 rocket.left=true;
	    }
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		    	ob.addprojectile(rocket.getProjectile());
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
	         rocket.up=false;
	    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			 rocket.right=false;
	    }
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			 rocket.down=false;
	    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			 rocket.left=false;
	    }
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
