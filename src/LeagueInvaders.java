import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int Width = 500;
	public static final int Length = 800;
	JFrame frame;
	GamePanel gp;

public static void main(String[] args) {
LeagueInvaders leagueinv = new LeagueInvaders();
leagueinv.setup();

}
public void setup() {
frame.add(gp);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setSize(Width, Length);
frame.addKeyListener(gp);
}
public LeagueInvaders() {	
	frame = new JFrame();
	gp = new GamePanel();

}
}

