import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font smallerfont;	
	Timer frameDraw;
@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	    frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
}

	public GamePanel() {
		 titleFont = new Font("Oswald", Font.PLAIN, 48);	
		 smallerfont = new Font("New Times Roman", Font.PLAIN, 20);
	}
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		
	}
	void updateEndState()  {  
		
	}
	void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.Width, LeagueInvaders.Length);
		g.setFont(titleFont);
		g.setColor(Color.GRAY);
		g.drawString("LEAGUE INVADERS", 32, 100);
		g.setFont(smallerfont);
		g.setColor(Color.WHITE);
		g.drawString("press ENTER to start", 136, 312);
		g.setFont(smallerfont);
		g.setColor(Color.WHITE);
		g.drawString("press SPACE for intstructions", 107, 530);
	}
	void drawGameState(Graphics g) {  
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.Width, LeagueInvaders.Length);
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.Width, LeagueInvaders.Length);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 100, 100);
		g.setFont(smallerfont);
		g.setColor(Color.WHITE);
		g.drawString("You were killed", 156, 312);
		g.setFont(smallerfont);
		g.setColor(Color.WHITE);
		g.drawString("press ENTER to restart", 128, 530);
		
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

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    }
		    else {
		        currentState++;
		    }
		    
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
	        System.out.println("UP");
	    }
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
	        System.out.println("RIGHT");
	    }
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
	        System.out.println("DOWN");
	    }
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
	        System.out.println("LEFT");
	    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
