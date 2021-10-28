import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int WIDTH = 500;
	public static final int LENGTH = 800;
	JFrame frame;
	GamePanel gp;
 
	
public static void main(String[] args) {
LeagueInvaders leagueinv = new LeagueInvaders();
leagueinv.setup();

}
public void setup() {
frame.addMouseListener(gp);	
frame.add(gp);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setSize(WIDTH, LENGTH);
frame.addKeyListener(gp);
}
public LeagueInvaders() {	
	frame = new JFrame();
	gp = new GamePanel();
}
}

  